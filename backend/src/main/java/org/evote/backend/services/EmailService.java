package org.evote.backend.services;

import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.emails.Email;
import com.mailersend.sdk.exceptions.MailerSendException;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.exceptions.AccountNotFoundException;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.exceptions.CodeAlreadySent;
import org.evote.backend.users.user.exceptions.UserIncompleteDataException;
import org.evote.backend.users.user.repository.UserRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
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

    private final UserRepository userRepository;
    private final AccountService accountService;

    public EmailService(UserRepository userRepository, AccountService accountService) {
        this.userRepository = userRepository;
        this.accountService = accountService;
    }

    private String generateOneTimeCode() {
        Random random = new Random();
        int code = random.nextInt(999999);
        return String.format("%06d", code);
    }

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
        sendEmailWithCode(userEmail, code);
        user.setCode(code);
        userRepository.save(user);

        return "Kod został wysłany!";
    }

    private void sendEmailWithCode(String userEmail, String code) {
        Email email = new Email();
        email.setFrom("evote.support", "MS_LRjWwk@trial-3yxj6ljv0p7ldo2r.mlsender.net");
        email.addRecipient(userEmail, userEmail);
        email.setSubject("Twój jednorazowy kod do głosowania!");
        String htmlBody = generateHtmlBody(code, userEmail);
        email.setHtml(htmlBody);
        MailerSend ms = new MailerSend();
        ms.setToken("mlsn.fb93e420c92cf81723b2ca30ca6252aacf100fa2ccd0a95714a3f73dd44cb64d");

        try {
            MailerSendResponse response = ms.emails().send(email);
            System.out.println("Email sent successfully. Message ID: " + response.messageId);
        } catch (MailerSendException e) {
            e.printStackTrace();
            throw new RuntimeException("Wystąpił błąd podczas wysyłania emaila!");
        }
    }

    private String generateHtmlBody(String code, String userEmail) {
        try {
            String htmlTemplate = readHtmlTemplate("mail_template.html");
            htmlTemplate = htmlTemplate.replace("{$code}", code);
            htmlTemplate = htmlTemplate.replace("{$to}", userEmail);
            return htmlTemplate;
        } catch (IOException e) {
            throw new RuntimeException("Błąd podczas wczytywania szablonu HTML!");
        }
    }

    private String readHtmlTemplate(String templateName) throws IOException {
        Resource resource = new ClassPathResource(templateName);
        byte[] bytes = Files.readAllBytes(Paths.get(resource.getURI()));
        return new String(bytes, StandardCharsets.UTF_8);
    }
}