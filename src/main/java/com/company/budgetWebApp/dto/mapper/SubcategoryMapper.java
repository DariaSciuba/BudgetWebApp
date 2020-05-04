package com.company.budgetWebApp.dto.mapper;

import com.company.budgetWebApp.dao.entity.SubcategoryEntity;
import com.company.budgetWebApp.dto.SubcategoryDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubcategoryMapper {

    private final CategoryMapper categoryMapper;

    public SubcategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public SubcategoryEntity mapSubcategoryDtoToEntity(SubcategoryDTO subcategoryDTO) {
        SubcategoryEntity subcategoryEntity = new SubcategoryEntity();
        subcategoryEntity.setName(subcategoryDTO.getName());
        return subcategoryEntity;
    }

    public SubcategoryDTO mapSubcategoryEntityToDto(SubcategoryEntity subcategoryEntity){
        SubcategoryDTO subcategoryDTO = new SubcategoryDTO();
        subcategoryDTO.setId(subcategoryEntity.getId());
        subcategoryDTO.setName(subcategoryEntity.getName());
        subcategoryDTO.setCategory(categoryMapper.mapCategoryEntityToDto(subcategoryEntity.getCategory()));
        return subcategoryDTO;
    }

    public List<SubcategoryEntity> mapSubcategoryListDtoToEntity(List<SubcategoryDTO> subcategoryDtos) {
        return subcategoryDtos.stream().map(this::mapSubcategoryDtoToEntity).collect(Collectors.toList());
    }

    public List<SubcategoryDTO> mapSubcategoryListEntityToDto(List<SubcategoryEntity> subcategoryEntities) {
        return subcategoryEntities.stream().map(this::mapSubcategoryEntityToDto).collect(Collectors.toList());
    }

}
