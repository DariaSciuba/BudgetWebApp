package com.company.budgetWebApp.service.mapper;

import com.company.budgetWebApp.dao.entity.AccountEntity;
import com.company.budgetWebApp.service.dto.AccountDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {IncomeMapper.class, ExpenseMapper.class})
public interface AccountMapper {

    @Mapping(target ="number", source ="accountNumber")
    @Mapping(target ="type", source ="accountType")
    @Mapping(target ="balance", source ="balanceDTO")
    @Mapping(target="incomes", source="incomesDTO", qualifiedByName ="mapToIncomeList")
    @Mapping(target="expenses", source="expensesDTO", qualifiedByName ="mapToExpenseList")
    AccountEntity accountDtoToEntity(AccountDTO accountDTO);

    @InheritInverseConfiguration
    @Mapping(target="incomesDTO", source="incomes", qualifiedByName ="mapToIncomeDTOList")
    @Mapping(target = "expensesDTO", source = "expenses", qualifiedByName = "mapToExpenseDTOList")
    AccountDTO accountEntityToDto(AccountEntity accountEntity);

    List<AccountEntity> accountDtosToEntity(List<AccountDTO> accountDTOS);

    List<AccountDTO> accountEntityToDtos(List<AccountEntity> accountEntities);

}
