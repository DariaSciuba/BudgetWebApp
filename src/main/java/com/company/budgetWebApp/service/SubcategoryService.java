package com.company.budgetWebApp.service;

import com.company.budgetWebApp.dao.entity.SubcategoryEntity;
import com.company.budgetWebApp.dao.repository.SubcategoryRepository;
import com.company.budgetWebApp.service.dto.SubcategoryDTO;
import com.company.budgetWebApp.service.mapper.SubcategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public SubcategoryEntity save(SubcategoryEntity subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    public void deleteById(Long id) {
        subcategoryRepository.deleteById(id);
    }

}
