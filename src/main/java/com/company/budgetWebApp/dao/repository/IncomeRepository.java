package com.company.budgetWebApp.dao.repository;

import com.company.budgetWebApp.dao.entity.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, Long> {

    @Query(value = "SELECT * FROM Incomes JOIN Subcategories On Incomes.subcategory_id = Subcategories.id " +
            "WHERE date = ?1 ORDER BY Subcategories.name, Incomes.id", nativeQuery = true)
    List<IncomeEntity> findIncomesByDate(Date date);

    @Query(value = "SELECT date FROM Incomes ORDER BY date", nativeQuery = true)
    List<Date> findDatesFromIncomes();
}
