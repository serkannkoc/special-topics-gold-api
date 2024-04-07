package org.st_gold.special_topics_gold.dto;

import lombok.Data;

@Data
public class SellGoldDTO {
    private Long userId;
    private Long goldAccountId;
    private Long tlAccountId;
    private Long goldId;
    private double amount;
}
