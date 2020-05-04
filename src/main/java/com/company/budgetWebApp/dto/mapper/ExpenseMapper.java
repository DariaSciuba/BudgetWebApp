package com.company.budgetWebApp.dto.mapper;

import com.company.budgetWebApp.dao.entity.ExpenseEntity;
import com.company.budgetWebApp.dto.ExpenseDTO;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {

        private final SubcategoryMapper subcategoryMapper;

        public ExpenseMapper(SubcategoryMapper subcategoryMapper) {
                this.subcategoryMapper = subcategoryMapper;
        }

        public ExpenseEntity mapExpenseDtoToEntity(ExpenseDTO expenseDTO) {
                ExpenseEntity expenseEntity = new ExpenseEntity();
                expenseEntity.setDate(expenseDTO.getDate());
                expenseEntity.setAmount(expenseDTO.getAmount());
                expenseEntity.setNote(expenseDTO.getNote());
                return expenseEntity;
        }

        public ExpenseDTO mapExpenseEntityToDto(ExpenseEntity expenseEntity) {
                ExpenseDTO expenseDTO = new ExpenseDTO();
                expenseDTO.setId(expenseEntity.getId());
                expenseDTO.setDate(expenseEntity.getDate());
                expenseDTO.setSubcategory(subcategoryMapper.mapSubcategoryEntityToDto(expenseEntity.getSubcategory()));
                expenseDTO.setAmount(expenseEntity.getAmount());
                expenseDTO.setNote(expenseEntity.getNote());
                return expenseDTO;
        }



}
