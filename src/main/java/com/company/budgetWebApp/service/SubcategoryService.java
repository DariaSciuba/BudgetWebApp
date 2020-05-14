package com.company.budgetWebApp.service;

import com.company.budgetWebApp.dao.entity.SubcategoryEntity;
import com.company.budgetWebApp.dao.repository.SubcategoryRepository;
import com.company.budgetWebApp.service.dto.SubcategoryDTO;
import com.company.budgetWebApp.service.mapper.SubcategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SubcategoryService {

    private SubcategoryRepository subcategoryRepository;
    private SubcategoryMapper subcategoryMapper;

    @Autowired
    public SubcategoryService(SubcategoryRepository subcategoryRepository, SubcategoryMapper subcategoryMapper) {
        this.subcategoryRepository = subcategoryRepository;
        this.subcategoryMapper = subcategoryMapper;
    }

    public SubcategoryEntity mapSubcategoryDtoToEntity(SubcategoryDTO subcategoryDTO) {
        return subcategoryMapper.subcategoryDtoToEntity(subcategoryDTO);
    }

    public SubcategoryDTO mapSubcategoryEntityToDto(SubcategoryEntity subcategoryEntity) {
        return subcategoryMapper.subcategoryEntityToDto(subcategoryEntity);
    }

    public List<SubcategoryDTO> mapSubcategoryListEntityToDto(List<SubcategoryEntity> subcategoryEntityList) {
        return subcategoryMapper.subcategoryEntityToDtos(subcategoryEntityList);
    }

    public Optional<SubcategoryEntity> findById(Long id) {
        return subcategoryRepository.findById(id);
    }

    public List<SubcategoryEntity> findAll() {
        return subcategoryRepository.findAll();
    }

    public List<SubcategoryEntity> findSubcategoriesIncomes() {
        List<SubcategoryEntity> subcategoriesIncomes = new ArrayList<>();
        for(SubcategoryEntity subcategoryEntity : subcategoryRepository.findAll()) {
            if(subcategoryEntity.getCategory().getType().equals("income")) {
                subcategoriesIncomes.add(subcategoryEntity);
            }
        }
        Arrays.sort(new List[]{subcategoriesIncomes});
        return subcategoriesIncomes;
    }

    public List<SubcategoryEntity> findSubcategoriesExpenses() {
        List<SubcategoryEntity> subcategoriesExpenses = new ArrayList<>();
        for(SubcategoryEntity subcategoryEntity : subcategoryRepository.findAll()) {
            if(subcategoryEntity.getCategory().getType().equals("expense")) {
                subcategoriesExpenses.add(subcategoryEntity);
            }
        }
        Arrays.sort(new List[]{subcategoriesExpenses});
        return subcategoriesExpenses;
    }

    public SubcategoryEntity save(SubcategoryEntity subcategory) {
        String subcategoryName = subcategory.getName();
        String subcategoryChecker = subcategoryName.substring(0,1).toUpperCase() + subcategoryName.substring(1);
        subcategory.setName(subcategoryChecker);
        return subcategoryRepository.save(subcategory);
    }

    public void deleteById(Long id) {
        subcategoryRepository.deleteById(id);
    }



}
