package com.company.budgetWebApp.service;

import com.company.budgetWebApp.dao.entity.AccountEntity;
import com.company.budgetWebApp.dao.repository.AccountRepository;
import com.company.budgetWebApp.service.dto.AccountDTO;
import com.company.budgetWebApp.service.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    @Autowired
    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public AccountEntity mapAccountDtoToEntity(AccountDTO accountDTO) {
        return accountMapper.accountDtoToEntity(accountDTO);
    }

    public AccountDTO mapAccountEntityToDto(AccountEntity accountEntity) {
        return accountMapper.accountEntityToDto(accountEntity);
    }

    public List<AccountEntity> mapAccountListDtoToEntity(List<AccountDTO> accountDTOS) {
        return accountMapper.accountDtosToEntity(accountDTOS);
    }

    public List<AccountDTO> mapAccountListEtityToDto(List<AccountEntity> accountEntities) {
        return accountMapper.accountEntityToDtos(accountEntities);
    }

    public Optional<AccountEntity> findById(Long id) {
        return accountRepository.findById(id);
    }

    public List<AccountEntity> findAll() { return accountRepository.findAll(); }

    public AccountEntity save(AccountEntity accountEntity) { return accountRepository.save(accountEntity); }

    public void deleteById(Long id) { accountRepository.deleteById(id); }
}
