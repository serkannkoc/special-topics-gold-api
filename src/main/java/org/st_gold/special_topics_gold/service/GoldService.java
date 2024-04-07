package org.st_gold.special_topics_gold.service;

import org.springframework.stereotype.Service;
import org.st_gold.special_topics_gold.dto.BuyGoldDTO;
import org.st_gold.special_topics_gold.dto.SellGoldDTO;
import org.st_gold.special_topics_gold.model.Account;
import org.st_gold.special_topics_gold.model.Emtia;
import org.st_gold.special_topics_gold.model.Gold;
import org.st_gold.special_topics_gold.model.Transaction;
import org.st_gold.special_topics_gold.repository.GoldRepository;

import java.util.List;
import java.util.Random;

@Service
public class GoldService {
    private final GoldRepository goldRepository;
    private final AccountService accountService;
    private final TransactionService transactionService;
    private final EmtiaService emtiaService;
    public GoldService(GoldRepository goldRepository, AccountService accountService, TransactionService transactionService, EmtiaService emtiaService) {
        this.goldRepository = goldRepository;
        this.accountService = accountService;
        this.transactionService = transactionService;
        this.emtiaService = emtiaService;
    }

    public List<Gold> getGoldPriceHistory() {
        return goldRepository.findAll();
    }

    public Gold calculateGoldValue(){
        Random random = new Random();
        double price = 2000 + random.nextDouble() * (2500-2000);
        return goldRepository.save(new Gold(price));
    }

    public void sellGold(SellGoldDTO sellGoldDTO){
        Account goldAccount =   accountService.getAccountById(sellGoldDTO.getGoldAccountId());
        Account tlAccount = accountService.getAccountById(sellGoldDTO.getTlAccountId());
        Gold gold = goldRepository.findById(sellGoldDTO.getGoldId()).orElseThrow(() -> new IllegalArgumentException("Gold not found"));

        double amount = gold.getPrice() * sellGoldDTO.getAmount();
        goldAccount.setBalance(goldAccount.getBalance() - sellGoldDTO.getAmount());
        tlAccount.setBalance(tlAccount.getBalance() + amount);

        Transaction transaction = new Transaction("sell",sellGoldDTO.getAmount(),amount,10);
        Transaction createdTransaction = transactionService.createTransaction(transaction);
//        Emtia emtia = new Emtia(sellGoldDTO.getUserId(),sourceAccount,transaction,gold);
//        Emtia createdEmtia = emtiaService.createEmtia(emtia);
    }

    public void buyGold(BuyGoldDTO buyGoldDTO){
        Account tlAccount =   accountService.getAccountById(buyGoldDTO.getTlAccountId());
        Account goldAccount = accountService.getAccountById(buyGoldDTO.getGoldAccountId());
        Gold gold = goldRepository.findById(buyGoldDTO.getGoldId()).orElseThrow(() -> new IllegalArgumentException("Gold not found"));

        double amount = gold.getPrice() * buyGoldDTO.getAmount();
        tlAccount.setBalance(tlAccount.getBalance() - amount);
        goldAccount.setBalance(goldAccount.getBalance() + buyGoldDTO.getAmount());

        Transaction transaction = new Transaction("buy",buyGoldDTO.getAmount(),amount,10);
        Transaction createdTransaction = transactionService.createTransaction(transaction);
//        Emtia emtia = new Emtia(buyGoldDTO.getUserId(),sourceAccount,createdTransaction,gold);
//        Emtia createdEmtia = emtiaService.createEmtia(emtia);
    }
}
