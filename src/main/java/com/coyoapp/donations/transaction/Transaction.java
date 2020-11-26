package com.coyoapp.donations.transaction;

import java.math.BigDecimal;
import java.time.Instant;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Transaction {

    @Id
    private String id;

    private String googlePlaceId;

    private String brainTreeTransactionId;

    private BigDecimal amount;

    private Instant created;
}
