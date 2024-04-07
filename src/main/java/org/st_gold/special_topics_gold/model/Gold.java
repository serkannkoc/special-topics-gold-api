package org.st_gold.special_topics_gold.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "gold")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at",updatable = false)
    private Date createdAt;
    @OneToOne(mappedBy = "gold", cascade = CascadeType.ALL)
    private Emtia emtia;

    public Gold(double price) {
        this.price = price;
    }
}
