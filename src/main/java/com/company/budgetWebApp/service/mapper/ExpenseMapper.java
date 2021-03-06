package com.company.budgetWebApp.service.mapper;

import com.company.budgetWebApp.dao.entity.ExpenseEntity;
import com.company.budgetWebApp.service.dto.ExpenseDTO;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface ExpenseMapper {

    @Mapping(target = "date", source = "dateDTO", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "subcategory", source = "subcategoryDTO")
    @Mapping(target = "account", source = "accountDTO")
    ExpenseEntity expenseDtoToEntity(ExpenseDTO expenseDTO);

    @InheritInverseConfiguration
    @Mapping(target = "subcategoryDTO.expensesDTO", ignore = true)
    @Mapping(target = "accountDTO.expensesDTO", ignore = true)
    ExpenseDTO expenseEntityToDto(ExpenseEntity expenseEntity);

    @Named("mapToExpenseList")
    List<ExpenseEntity> mapToExpenseList(List<ExpenseDTO> expenseDTOS);

    @Named("mapToExpenseDTOList")
    List<ExpenseDTO> mapToExpenseDTOList(Set<ExpenseEntity> expenseEntities);

}
