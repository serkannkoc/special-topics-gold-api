package org.st_gold.special_topics_gold.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.st_gold.special_topics_gold.model.Account;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a WHERE a.userID = :userId AND a.id = :accountId")
    Account findByUserIdAndAccountId(Long userId, Long accountId);

    List<Account> findByUserID(Long userId);
}
