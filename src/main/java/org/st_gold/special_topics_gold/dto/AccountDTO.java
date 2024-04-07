package org.st_gold.special_topics_gold.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.st_gold.special_topics_gold.model.Account;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private Long id;
    private String name;
    private String type;
    private double balance;
    private Long userID;

    public static AccountDTO fromEntity(Account account) {
        return new AccountDTO(
                account.getId(),
                account.getName(),
                account.getType(),
                account.getBalance(),
                account.getUserID()
        );
    }
}
