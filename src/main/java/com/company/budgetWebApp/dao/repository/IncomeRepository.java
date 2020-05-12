package com.company.budgetWebApp.dao.repository;

import com.company.budgetWebApp.dao.entity.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, Long> {
}
