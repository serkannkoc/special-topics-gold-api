package org.st_gold.special_topics_gold.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.st_gold.special_topics_gold.model.Gold;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoldDTO {
    private Long id;
    private double price;
    private Date createdAt;

    public static GoldDTO fromEntity(Gold gold) {
        return new GoldDTO(
                gold.getId(),
                gold.getPrice(),
                gold.getCreatedAt()
        );
    }
}