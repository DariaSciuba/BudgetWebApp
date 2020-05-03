package com.company.budgetWebApp.manager;

import com.company.budgetWebApp.dao.entity.CategoryEntity;
import com.company.budgetWebApp.dao.repository.CategoryRepository;
import com.company.budgetWebApp.dto.CategoryDTO;
import com.company.budgetWebApp.dto.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryManager {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryManager(CategoryRepository categoryRepository, CategoryMapper categoryMapper){
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryEntity mapCategoryDtoToEntity(CategoryDTO categoryDTO) {
        return categoryMapper.mapCategoryDtoToEntity(categoryDTO);
    }

    public CategoryDTO mapCategoryEntityToDto(CategoryEntity categoryEntity) {
        return categoryMapper.mapCategoryEntityToDto(categoryEntity);
    }

    public List<CategoryEntity> mapCategoryListDtoToEntity(List<CategoryDTO> categoryDtos) {
        return categoryMapper.mapCategoryListDtoToEntity(categoryDtos);
    }

    public List<CategoryDTO> mapCategoryListEntityToDto(List<CategoryEntity> categoryEntities) {
        return categoryMapper.mapCategoryListEntityToDto(categoryEntities);
    }

    public Optional<CategoryEntity> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    public CategoryEntity save(CategoryEntity category) {
        String categoryName = category.getName();
        String categoryChecker = categoryName.substring(0,1).toUpperCase() + categoryName.substring(1).toLowerCase();
        category.setName(categoryChecker);
        return categoryRepository.save(category);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

}
