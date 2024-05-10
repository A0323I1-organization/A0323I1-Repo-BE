package a0323i_cinema_professtional_be.service.account;

import a0323i_cinema_professtional_be.entity.Account;
import org.springframework.data.jpa.repository.Query;

public interface AccountService{
    Account findById(Integer accountId);
}
