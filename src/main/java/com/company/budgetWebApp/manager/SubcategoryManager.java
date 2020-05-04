package com.company.budgetWebApp.manager;

import com.company.budgetWebApp.dao.entity.CategoryEntity;
import com.company.budgetWebApp.dao.entity.SubcategoryEntity;
import com.company.budgetWebApp.dao.repository.SubcategoryRepository;
import com.company.budgetWebApp.dto.SubcategoryDTO;
import com.company.budgetWebApp.dto.mapper.SubcategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubcategoryManager {

    private SubcategoryRepository subcategoryRepository;
    private SubcategoryMapper subcategoryMapper;

    @Autowired
    public SubcategoryManager(SubcategoryRepository subcategoryRepository,
                              SubcategoryMapper subcategoryMapper) {
        this.subcategoryRepository = subcategoryRepository;
        this.subcategoryMapper = subcategoryMapper;
    }

    public SubcategoryEntity mapSubcategoryDtoToEntity(SubcategoryDTO subcategoryDTO) {
        return subcategoryMapper.mapSubcategoryDtoToEntity(subcategoryDTO);
    }

    public SubcategoryDTO mapSubcategoryEntityToDto(SubcategoryEntity subcategoryEntity) {
        return subcategoryMapper.mapSubcategoryEntityToDto(subcategoryEntity);
    }

    public List<SubcategoryDTO> mapSubcategoryListEntityToDto(List<SubcategoryEntity> subcategoryEntityList) {
        return subcategoryMapper.mapSubcategoryListEntityToDto(subcategoryEntityList);
    }

    public Optional<SubcategoryEntity> findById(Long id) {
        return subcategoryRepository.findById(id);
    }

    public List<SubcategoryEntity> findAll() {
        return subcategoryRepository.findAll();
    }

    public SubcategoryEntity save(SubcategoryEntity subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    public void deleteById(Long id) {
        subcategoryRepository.deleteById(id);
    }

}
