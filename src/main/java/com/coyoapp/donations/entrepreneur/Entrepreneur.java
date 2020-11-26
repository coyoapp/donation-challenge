package com.coyoapp.donations.entrepreneur;

import java.time.Instant;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Entrepreneur {

    @Id
    private String id;

    private String googlePlaceId;

    private String firstName;

    private String lastName;

    private String email;

    private Instant created;
}
