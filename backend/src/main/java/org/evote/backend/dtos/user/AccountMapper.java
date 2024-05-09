package org.evote.backend.dtos.user;

import org.evote.backend.users.account.entity.Account;

public class AccountMapper {

    public static AccountDTO toAccountDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getAccount_id());
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

    public static AccountUserDTO toAccountUserDTO(Account account) {
        AccountUserDTO accountUserDTO = new AccountUserDTO();
        accountUserDTO.setEmail(account.getEmail());
        accountUserDTO.setHasVoted(account.getHasVoted());
        accountUserDTO.setIsAccountActive(account.getIsAccountActive());
        accountUserDTO.setUser_id(account.getUser().getUser_id());
        accountUserDTO.setName(account.getUser().getName());
        accountUserDTO.setSurname(account.getUser().getSurname());
        accountUserDTO.setSex(account.getUser().getSex());
        accountUserDTO.setBirthDate(account.getUser().getBirthDate());
        accountUserDTO.setEducation(String.valueOf(account.getUser().getEducation()));
        accountUserDTO.setProfession(account.getUser().getProfession());
        return accountUserDTO;
    }
}