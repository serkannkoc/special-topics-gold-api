package org.st_gold.special_topics_gold.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.st_gold.special_topics_gold.dto.AccountDTO;
import org.st_gold.special_topics_gold.dto.TransactionDTO;
import org.st_gold.special_topics_gold.model.Account;
import org.st_gold.special_topics_gold.model.Transaction;
import org.st_gold.special_topics_gold.service.AccountService;
import org.st_gold.special_topics_gold.service.TransactionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final AccountService accountService;
    private final TransactionService transactionService;
    public UserController( AccountService accountService, TransactionService transactionService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    @GetMapping("/{userID}/accounts/{accountID}")
    public ResponseEntity<AccountDTO> getAccountDetails(@PathVariable Long userID, @PathVariable Long accountID) {
        Account account = accountService.getAccountByUserIdAndAccountId(userID,accountID);
        AccountDTO accountDTO = AccountDTO.fromEntity(account);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @GetMapping("/{userID}/transactions")
    public ResponseEntity<List<TransactionDTO>> getTransactionHistory(@PathVariable Long userID ) {
        List<Transaction> transactions = transactionService.getTransactionHistory(userID);
        List<TransactionDTO> transactionDTOs = transactions.stream().map(TransactionDTO::fromEntity).collect(Collectors.toList());
        return new ResponseEntity<>(transactionDTOs, HttpStatus.OK);
    }

    @GetMapping("/{userID}/accounts")
    public ResponseEntity<List<AccountDTO>> getAccounts(@PathVariable Long userID) {
        List<Account> accounts = accountService.getAccountsByUserId(userID);
        List<AccountDTO> accountDTOs = accounts.stream().map(AccountDTO::fromEntity).collect(Collectors.toList());
        return new ResponseEntity<>(accountDTOs, HttpStatus.OK);
    }


}
