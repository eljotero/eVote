package org.evote.backend.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;

    }
    private String generateOneTimeCode() {
        Random random = new Random();
        int code = random.nextInt(999999);
        return String.format("%06d", code);
    }
    @Async
    public void sendEmail(String to) {
        try {
            String htmlBody = readHtmlTemplate("mail_template.html");
            htmlBody = htmlBody.replace("{$code}", generateOneTimeCode());
            htmlBody = htmlBody.replace("{$to}", to);
            String subject = "Twój jednorazowy kod do głosowania!";
            sendHtmlEmail(to, subject, htmlBody);

        } catch (IOException | MessagingException e) {
            e.printStackTrace();
        }
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