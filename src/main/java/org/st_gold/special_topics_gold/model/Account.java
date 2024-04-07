package org.st_gold.special_topics_gold.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private double balance;
    private Long userID;
    @OneToOne(mappedBy = "account_id", cascade = CascadeType.ALL)
    private Emtia emtia;
}

