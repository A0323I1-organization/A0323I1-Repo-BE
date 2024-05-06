package a0323i1_cinema_professtional_be.service.account;

import a0323i1_cinema_professtional_be.entity.Account;
import a0323i1_cinema_professtional_be.repository.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository accountRepository;
    @Override
    public Account findById(Integer accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }
}
