package com.coyoapp.donations.payment;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TokenResponse {

    private final String token;
}
