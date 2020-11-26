package com.coyoapp.donations.invitation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/invitationtokens")
@RestController
@RequiredArgsConstructor
public class InvitationTokenController {

    private final InvitationTokenRepository invitationTokenRepository;

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(invitationTokenRepository.findAll());
    }
}
