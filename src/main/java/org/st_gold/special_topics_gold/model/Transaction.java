package org.st_gold.special_topics_gold.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double amount;
    private double price;
    private double fee;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at",updatable = false)
    private Date createdAt;
    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
    private Emtia emtia;

    public Transaction(String type, double amount, double price, double fee) {
        this.type = type;
        this.amount = amount;
        this.price = price;
        this.fee = fee;
    }
}
