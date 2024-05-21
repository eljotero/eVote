package org.evote.backend.unit.services;

import jakarta.mail.internet.MimeMessage;
import org.evote.backend.services.AccountService;
import org.evote.backend.services.EmailService;
import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.user.entity.User;
import org.evote.backend.users.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmailServiceTests {

    @Mock
    private JavaMailSender mailSender;

    @Mock
    private AccountService accountService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private EmailService emailService;

    Account account;

    String userEmail = "test@mail.com";

    User user;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        account = new Account();
        user = new User();
        account.setUser(user);
        MimeMessage mimeMessage = mock(MimeMessage.class);
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);
        doNothing().when(mailSender).send(mimeMessage);
    }

    @Test
    public void testSendEmail() {
        when(accountService.getAccountByEmail(userEmail)).thenReturn(java.util.Optional.of(account));
        String result = emailService.sendEmail(userEmail);
        assertEquals("Kod został wysłany!", result);
    }

    @Test
    public void testSendEmailAccountNotFound() {
        when(accountService.getAccountByEmail(userEmail)).thenReturn(java.util.Optional.empty());
        try {
            emailService.sendEmail(userEmail);
        } catch (Exception e) {
            assertEquals("Konto nie istnieje", e.getMessage());
        }
    }

    @Test
    public void testSendEmailCodeAlreadySent() {
        user.setCode("123456");
        when(accountService.getAccountByEmail(userEmail)).thenReturn(java.util.Optional.of(account));
        try {
            emailService.sendEmail(userEmail);
        } catch (Exception e) {
            assertEquals("Kod został już wysłany!", e.getMessage());
        }
    }
}
