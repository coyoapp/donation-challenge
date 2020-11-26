package com.coyoapp.donations.entrepreneur;

import lombok.Data;

@Data
public class EntrepreneurCreateRequest {

    private String invitationToken;

    private String firstName;

    private String lastName;

    private String email;
}
