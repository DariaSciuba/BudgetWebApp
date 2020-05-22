package com.company.budgetWebApp.service;

import com.company.budgetWebApp.dao.entity.CategoryEntity;
import com.company.budgetWebApp.dao.repository.CategoryRepository;
import com.company.budgetWebApp.service.dto.CategoryDTO;
import com.company.budgetWebApp.service.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper){
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryEntity mapCategoryDtoToEntity(CategoryDTO categoryDTO) {
        return categoryMapper.categoryDtoToEntity(categoryDTO);
    }

    public CategoryDTO mapCategoryEntityToDto(CategoryEntity categoryEntity) {
        return categoryMapper.categoryEntityToDto(categoryEntity);
    }

    public List<CategoryEntity> mapCategoryListDtoToEntity(List<CategoryDTO> categoryDtos) {
        return categoryMapper.categoryDtosToEntity(categoryDtos);
    }

    public List<CategoryDTO> mapCategoryListEntityToDto(List<CategoryEntity> categoryEntities) {
        return categoryMapper.categoryEntityToDtos(categoryEntities);
    }

    public Optional<CategoryEntity> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll().stream()
                .sorted(Comparator.comparing(CategoryEntity::getType).reversed().thenComparing(CategoryEntity::getName))
                .collect(Collectors.toList());
    }

    public CategoryEntity save(CategoryEntity category) {
        String categoryName = category.getName();
        String categoryChecker = categoryName.substring(0,1).toUpperCase() + categoryName.substring(1);
        category.setName(categoryChecker);
        return categoryRepository.save(category);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

}
