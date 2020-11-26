package com.coyoapp.donations.transaction;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsSummary {

    private BigDecimal amount = BigDecimal.ZERO;

    private int transactionQuantity;
}
