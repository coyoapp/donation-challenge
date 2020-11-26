package com.coyoapp.donations.transaction;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

    private BigDecimal amount = BigDecimal.ZERO;

    private String company;

    private String city;
}
