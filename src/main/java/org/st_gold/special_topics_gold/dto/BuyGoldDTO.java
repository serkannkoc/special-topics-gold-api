package org.st_gold.special_topics_gold.dto;

import lombok.Data;

@Data
public class BuyGoldDTO {
    private Long userId;
    private Long tlAccountId;
    private Long goldAccountId;
    private Long goldId;
    private double amount;
}
