package org.evote.backend.users.account.dtos;

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
        //account.setRole(accountCreateDTO.getRole());
        ///account.setHasVoted(accountCreateDTO.getHasVoted());
        //account.setIsAccountActive(accountCreateDTO.getIsAccountActive());

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
        accountUserDTO.setName(account.getUser().getName());
        accountUserDTO.setSurname(account.getUser().getSurname());
        accountUserDTO.setSex(account.getUser().getSex());
        accountUserDTO.setBirthDate(account.getUser().getBirthDate());
        accountUserDTO.setEducation(String.valueOf(account.getUser().getEducation()));
        accountUserDTO.setProfession(account.getUser().getProfession());
        accountUserDTO.setCityType(String.valueOf(account.getUser().getCityType()));
        accountUserDTO.setPersonalIdNumber(account.getUser().getPersonalIdNumber());
        accountUserDTO.setZipCode(account.getUser().getAddress().getZip_code());
        accountUserDTO.setCity(account.getUser().getAddress().getCity());
        accountUserDTO.setCountry(account.getUser().getAddress().getCountry());
        accountUserDTO.setAddressLine(account.getUser().getAddress().getAddress_line());
        accountUserDTO.setVoivodeship(account.getUser().getAddress().getVoivodeship());
        return accountUserDTO;
    }
}