package org.st_gold.special_topics_gold.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.st_gold.special_topics_gold.model.Transaction;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private Long id;
    private String type;
    private double amount;
    private double price;
    private double fee;
    private Date createdAt;

    public static TransactionDTO fromEntity(Transaction transaction) {
        return new TransactionDTO(
                transaction.getId(),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getPrice(),
                transaction.getFee(),
                transaction.getCreatedAt()
        );
    }
}