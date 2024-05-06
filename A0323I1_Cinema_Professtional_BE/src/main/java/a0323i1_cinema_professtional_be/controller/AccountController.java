package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
}
