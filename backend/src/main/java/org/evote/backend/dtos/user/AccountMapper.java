package org.evote.backend.dtos.user;

import org.evote.backend.users.account.entity.Account;
import org.evote.backend.users.user.entity.User;

public class AccountMapper {

    public static AccountDTO toAccountDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
//        accountDTO.setId(account.getAccount_id());
        accountDTO.setEmail(account.getEmail());
        accountDTO.setRole(account.getRole());
        accountDTO.setHasVoted(account.getHasVoted());

        return accountDTO;
    }

    public static Account toAccount(AccountCreateDTO accountCreateDTO) {
        Account account = new Account();
        account.setEmail(accountCreateDTO.getEmail());
        account.setPassword(accountCreateDTO.getPassword());
        account.setRole(accountCreateDTO.getRole());
        account.setHasVoted(accountCreateDTO.getHasVoted());
        account.setIsAccountActive(accountCreateDTO.getIsAccountActive());

        return account;
    }

    public static AccountLoginResponseDTO toAccountLoginResponseDTO(Account account) {
        AccountLoginResponseDTO accountLoginResponseDTO = new AccountLoginResponseDTO();
        accountLoginResponseDTO.setEmail(account.getEmail());

        return accountLoginResponseDTO;
    }

}