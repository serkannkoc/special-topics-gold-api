package org.st_gold.special_topics_gold.service;

import org.springframework.stereotype.Service;
import org.st_gold.special_topics_gold.model.Account;
import org.st_gold.special_topics_gold.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public Account getAccountByUserIdAndAccountId(Long userId, Long accountId) {
        Account account = accountRepository.findByUserIdAndAccountId(userId, accountId);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        return account;
    }

    public Account getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId).
                orElseThrow(() -> new IllegalArgumentException("Account not found"));
        return account;
    }

    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAccountsByUserId(Long userId) {
        List<Account> accounts = accountRepository.findByUserID(userId);
        return accounts;
    }
}
