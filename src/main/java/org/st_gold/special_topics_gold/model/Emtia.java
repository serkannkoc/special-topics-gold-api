package org.st_gold.special_topics_gold.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "emtia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emtia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account_id;
    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;
    @OneToOne
    @JoinColumn(name = "gold_id")
    private Gold gold;

    public Emtia(Long userId, Account account_id, Transaction transaction, Gold gold) {
        this.userId = userId;
        this.account_id = account_id;
        this.transaction = transaction;
        this.gold = gold;
    }
}
