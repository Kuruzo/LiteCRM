package dev.artemon.crm.account.interfaces.rest;

import dev.artemon.crm.account.application.AccountManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class Controller {
    private final AccountManager manager;

}