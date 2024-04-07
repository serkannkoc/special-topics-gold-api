package org.st_gold.special_topics_gold.controller;

import org.springframework.web.bind.annotation.*;
import org.st_gold.special_topics_gold.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


}
