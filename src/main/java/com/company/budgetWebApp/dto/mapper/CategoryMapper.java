package com.company.budgetWebApp.dto.mapper;

import com.company.budgetWebApp.dao.entity.CategoryEntity;
import com.company.budgetWebApp.dto.CategoryDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public CategoryEntity mapCategoryDtoToEntity(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(categoryDTO.getName());
        categoryEntity.setType(categoryDTO.getType());
        return categoryEntity;
    }

    public CategoryDTO mapCategoryEntityToDto(CategoryEntity categoryEntity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryEntity.getId());
        categoryDTO.setName(categoryEntity.getName());
        categoryDTO.setType(categoryEntity.getType());
        return categoryDTO;
    }

    public List<CategoryEntity> mapCategoryListDtoToEntity(List<CategoryDTO> categoryDtos) {
        return categoryDtos.stream().map(this::mapCategoryDtoToEntity).collect(Collectors.toList());
    }

    public List<CategoryDTO> mapCategoryListEntityToDto(List<CategoryEntity> categoryEntities) {
        return categoryEntities.stream().map(this::mapCategoryEntityToDto).collect(Collectors.toList());
    }

}
