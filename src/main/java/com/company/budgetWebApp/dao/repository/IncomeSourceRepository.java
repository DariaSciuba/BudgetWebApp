package com.company.budgetWebApp.dao.repository;

import com.company.budgetWebApp.dao.entity.IncomeSourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeSourceRepository extends JpaRepository<IncomeSourceEntity, Long> {
}
