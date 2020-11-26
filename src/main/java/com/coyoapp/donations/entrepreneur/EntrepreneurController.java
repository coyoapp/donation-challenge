package com.coyoapp.donations.entrepreneur;

import com.coyoapp.donations.invitation.InvitationTokenRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/entrepreneurs")
@RestController
@RequiredArgsConstructor
public class EntrepreneurController {

    private final EntrepreneurService entrepreneurService;

    @PostMapping
    public ResponseEntity createEntrepreneur(@RequestBody EntrepreneurCreateRequest request) {
        entrepreneurService.createEntrepreneur(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("invitationtokens")
    public ResponseEntity createInvitationToken(@RequestBody InvitationTokenRequest request) {
        return entrepreneurService.getByInvitationToken(request.getInvitationToken())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
