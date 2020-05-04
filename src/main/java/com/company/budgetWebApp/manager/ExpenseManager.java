package com.company.budgetWebApp.manager;

import com.company.budgetWebApp.dao.entity.ExpenseEntity;
import com.company.budgetWebApp.dao.repository.ExpenseRepository;
import com.company.budgetWebApp.dto.ExpenseDTO;
import com.company.budgetWebApp.dto.mapper.ExpenseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseManager {

    private ExpenseRepository expenseRepository;
    private ExpenseMapper expenseMapper;

    @Autowired
    public ExpenseManager(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
    }

    public ExpenseEntity mapExpenseDtoToEntity(ExpenseDTO expenseDTO) {
        return expenseMapper.mapExpenseDtoToEntity(expenseDTO);
    }

    public ExpenseDTO mapExpenseDtoToEntity(ExpenseEntity expenseEntity) {
        return expenseMapper.mapExpenseEntityToDto(expenseEntity);
    }

    public Optional<ExpenseEntity> findById(Long id) {
        return expenseRepository.findById(id);
    }

    public List<ExpenseEntity> findAll() {
        return expenseRepository.findAll();
    }

    public ExpenseEntity save(ExpenseEntity expense) {
        return expenseRepository.save(expense);
    }

    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }



}
