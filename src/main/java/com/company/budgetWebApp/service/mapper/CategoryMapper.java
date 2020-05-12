package com.company.budgetWebApp.service.mapper;

import com.company.budgetWebApp.dao.entity.CategoryEntity;
import com.company.budgetWebApp.service.dto.CategoryDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {SubcategoryMapper.class})
public interface CategoryMapper {

    @Mapping(target = "name", source = "categoryName")
    @Mapping(target = "type", source = "categoryType")
    @Mapping(target = "subcategories", source = "subcategoriesDTO", qualifiedByName = "mapToSubcategorySet")
    CategoryEntity categoryDtoToEntity(CategoryDTO categoryDTO);

    @InheritInverseConfiguration
    @Mapping(target = "subcategoriesDTO", source = "subcategories", qualifiedByName = "mapToSubcategoryDTOList")
    CategoryDTO categoryEntityToDto(CategoryEntity categoryEntity);

    List<CategoryEntity> categoryDtosToEntity(List<CategoryDTO> categoryDTOS);

    List<CategoryDTO> categoryEntityToDtos(List<CategoryEntity> categoryEntities);
}
