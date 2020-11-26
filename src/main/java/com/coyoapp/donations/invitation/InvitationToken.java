package com.coyoapp.donations.invitation;

import java.time.Instant;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@ToString
public class InvitationToken {

    @Id
    private String id;

    private String token;

    private String googlePlaceId;

    private Instant created;
}
