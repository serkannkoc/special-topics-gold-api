package org.st_gold.special_topics_gold.service;

import org.springframework.stereotype.Service;
import org.st_gold.special_topics_gold.model.Transaction;
import org.st_gold.special_topics_gold.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactionHistory(Long userId) {
        List<Transaction> transactions = transactionRepository.findAll();
        if (transactions == null) {
            throw new IllegalArgumentException("Transactions not found");
        }
        return transactions;
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
