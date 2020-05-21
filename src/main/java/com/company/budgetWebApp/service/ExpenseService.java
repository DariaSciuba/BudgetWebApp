package com.company.budgetWebApp.service;

import com.company.budgetWebApp.dao.entity.ExpenseEntity;
import com.company.budgetWebApp.dao.repository.ExpenseRepository;
import com.company.budgetWebApp.service.dto.ExpenseDTO;
import com.company.budgetWebApp.service.mapper.ExpenseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;
    private ExpenseMapper expenseMapper;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
    }

    public ExpenseEntity mapExpenseDtoToEntity(ExpenseDTO expenseDTO) {
        return expenseMapper.expenseDtoToEntity(expenseDTO);
    }

    public ExpenseDTO mapExpenseEntityToDto(ExpenseEntity expenseEntity) {
        return expenseMapper.expenseEntityToDto(expenseEntity);
    }

    public Optional<ExpenseEntity> findById(Long id) {
        return expenseRepository.findById(id);
    }

    public List<ExpenseEntity> findAll() {
        return expenseRepository.findAll().stream()
                .sorted(Comparator.comparing(ExpenseEntity::getDate))
                .collect(Collectors.toList());
    }

    public ExpenseEntity save(ExpenseEntity expense) {
        return expenseRepository.save(expense);
    }

    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }

    public Map<Date, List<ExpenseEntity>> findAllExpensesForDate() {
        List<Date> dates = expenseRepository.findDatesFromExpenses().stream().sorted().collect(Collectors.toList());
        Collections.sort(dates, Collections.reverseOrder());
        List<ExpenseEntity> expensesByDate;
        Map<Date, List<ExpenseEntity>> listExpensesForDate = new LinkedHashMap<>();

        for (Date date : dates) {
            expensesByDate = expenseRepository.findExpensesByDate(date);
            listExpensesForDate.put(date, expensesByDate);
        }
        return listExpensesForDate;
    }
}
