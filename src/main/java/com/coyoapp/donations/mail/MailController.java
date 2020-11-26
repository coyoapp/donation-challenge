package com.coyoapp.donations.mail;

import com.coyoapp.donations.invitation.InvitationToken;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/mail")
@RestController
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping
    public void send() {
        InvitationToken invitationToken = new InvitationToken();
        invitationToken.setToken(UUID.randomUUID().toString());
        mailService.sendInvitationTokenMail(invitationToken);
        mailService.sendSignupConfirmationMail();
        mailService.sendNewDonationsMail();
    }
}
