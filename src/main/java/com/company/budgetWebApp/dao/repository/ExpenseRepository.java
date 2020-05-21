package com.company.budgetWebApp.dao.repository;

import com.company.budgetWebApp.dao.entity.ExpenseEntity;
import com.company.budgetWebApp.dao.entity.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {

    @Query(value = "SELECT * FROM Expenses JOIN Subcategories On Expenses.subcategory_id = Subcategories.id " +
            "WHERE date = ?1 ORDER BY Subcategories.name, Expenses.id", nativeQuery = true)
    List<ExpenseEntity> findExpensesByDate(Date date);

    @Query(value = "SELECT date FROM Expenses ORDER BY date", nativeQuery = true)
    List<Date> findDatesFromExpenses();
}
