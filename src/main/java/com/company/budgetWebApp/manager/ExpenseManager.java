package com.company.budgetWebApp.manager;

import com.company.budgetWebApp.dao.entity.ExpenseEntity;
import com.company.budgetWebApp.dao.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseManager {

    private ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseManager(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Optional<ExpenseEntity> findById(Long id) {
        return expenseRepository.findById(id);
    }

    public Iterable<ExpenseEntity> findAll() {
        return expenseRepository.findAll();
    }

    public ExpenseEntity save(ExpenseEntity expense) {
        return expenseRepository.save(expense);
    }

    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }

}
