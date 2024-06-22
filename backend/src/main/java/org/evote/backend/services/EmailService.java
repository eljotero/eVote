package org.evote.backend.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.exceptions.CodeAlreadySent;
import org.evote.backend.users.user.exceptions.UserIncompleteDataException;
import org.evote.backend.users.user.repository.UserRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Random;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final UserRepository userRepository;
    private final AccountService accountService;

    public EmailService(JavaMailSender mailSender, UserRepository userRepository, AccountService accountService) {
        this.mailSender = mailSender;
        this.userRepository = userRepository;
        this.accountService = accountService;
    }

    private String generateOneTimeCode() {
        Random random = new Random();
        int code = random.nextInt(999999);
        return String.format("%06d", code);
    }

    @Async
    @Transactional
    public String sendEmail(String userEmail) {
        Optional<Account> account = accountService.getAccountByEmail(userEmail);
        if (account.isEmpty()) {
            throw new AccountNotFoundException("Konto nie istnieje");
        }
        User user = account.get().getUser();
        if (user.getCode() != null) {
            throw new CodeAlreadySent("Kod został już wysłany!");
        }
        if (user.getSex() == null || user.getAddress() == null || user.getPrecincts() == null || user.getName() == null
                || user.getSurname() == null || user.getBirthDate() == null || user.getPersonalIdNumber() == null
                || user.getEducation() == null || user.getCityType() == null || user.getProfession() == null) {
            throw new UserIncompleteDataException("Uzupełnij dane użytkownika!");
        }
        String code = generateOneTimeCode();
        try {
            String htmlBody = readHtmlTemplate("mail_template.html");
            htmlBody = htmlBody.replace("{$code}", code);
            htmlBody = htmlBody.replace("{$to}", userEmail);
            String subject = "Twój jednorazowy kod do głosowania!";
            sendHtmlEmail(userEmail, subject, htmlBody);
            user.setCode(code);
            userRepository.save(user);
        } catch (IOException | MessagingException e) {
            throw new RuntimeException("Wystąpił błąd podczas wysyłania emaila!");
        }
        return "Kod został wysłany!";
    }


    private String readHtmlTemplate(String templateName) throws IOException {
        Resource resource = new ClassPathResource(templateName);
        byte[] bytes = Files.readAllBytes(Paths.get(resource.getURI()));
        return new String(bytes, StandardCharsets.UTF_8);
    }

    private void sendHtmlEmail(String to, String subject, String htmlBody) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, StandardCharsets.UTF_8.name());
        helper.setTo(to);
        helper.setFrom("evote-support@example.com");
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        mailSender.send(message);
    }
}