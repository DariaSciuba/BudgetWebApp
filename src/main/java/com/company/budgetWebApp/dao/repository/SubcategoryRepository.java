package com.company.budgetWebApp.dao.repository;

import com.company.budgetWebApp.dao.entity.SubcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends JpaRepository<SubcategoryEntity, Long> {
}
