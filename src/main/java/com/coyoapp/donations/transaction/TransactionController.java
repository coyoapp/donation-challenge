package com.coyoapp.donations.transaction;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/transactions")
@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionRepository transactionRepository;
    private final TransactionService transactionService;

    @GetMapping("{invitationToken}/sum")
    public ResponseEntity getTransactionsSum(@PathVariable("invitationToken") String invitationToken) {
        TransactionsSummary summary = transactionService.getTransactionSummaryByInvitationToken(invitationToken);
        return ResponseEntity.ok(summary);
    }

    @GetMapping("history")
    public ResponseEntity getLast5Transactions() {
        List<TransactionResponse> transactions = transactionService.getLast5Transactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(transactionRepository.findAll());
    }
}
