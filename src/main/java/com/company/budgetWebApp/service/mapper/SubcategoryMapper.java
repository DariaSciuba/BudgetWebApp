package com.company.budgetWebApp.service.mapper;

import com.company.budgetWebApp.dao.entity.SubcategoryEntity;
import com.company.budgetWebApp.service.dto.SubcategoryDTO;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses =  {ExpenseMapper.class, IncomeMapper.class})
public interface SubcategoryMapper {

    @Mapping(target = "name", source = "subcategoryName")
    @Mapping(target = "category", source = "categoryDTO")
    @Mapping(target = "expenses", source = "expensesDTO", qualifiedByName = "mapToExpenseSet")
    @Mapping(target = "incomes", source = "incomesDTO", qualifiedByName = "mapToIncomeSet")
    SubcategoryEntity subcategoryDtoToEntity(SubcategoryDTO subcategoryDTO);

    @InheritInverseConfiguration
    @Mapping(target = "categoryDTO.subcategoriesDTO", ignore = true)
    @Mapping(target = "expensesDTO", source = "expenses", qualifiedByName = "mapToExpenseDTOList")
    @Mapping(target = "incomesDTO", source = "incomes", qualifiedByName = "mapToIncomeDTOList")
    SubcategoryDTO subcategoryEntityToDto(SubcategoryEntity subcategoryEntity);

    List<SubcategoryEntity> subcategoryDtosToEntity(List<SubcategoryDTO> subcategoryDTOS);

    List<SubcategoryDTO> subcategoryEntityToDtos(List<SubcategoryEntity> subcategoryEntities);

    @Named("mapToSubcategorySet")
    Set<SubcategoryEntity> mapToSubcategorySet(List<SubcategoryDTO> subcategoryDTOS);

    @Named("mapToSubcategoryDTOList")
    List<SubcategoryDTO> mapToSubcategoryDTOList(Set<SubcategoryEntity> subcategoryEntities);

}
