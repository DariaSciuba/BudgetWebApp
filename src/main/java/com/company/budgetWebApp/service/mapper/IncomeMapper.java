package com.company.budgetWebApp.service.mapper;

import com.company.budgetWebApp.dao.entity.IncomeEntity;
import com.company.budgetWebApp.service.dto.IncomeDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

@Mapper
public interface IncomeMapper {

    @Mapping(target = "date", source = "dateDTO", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "subcategory", source = "subcategoryDTO")
    IncomeEntity incomeDtoToEntity(IncomeDTO incomeDTO);

    @InheritInverseConfiguration
    @Mapping(target = "subcategoryDTO.incomesDTO", ignore = true)
    IncomeDTO incomeEntityToDto(IncomeEntity incomeEntity);

    @Named("mapToIncomeSet")
    Set<IncomeEntity> mapToIncomeSet(List<IncomeDTO> incomeDTOS);

    @Named("mapToIncomeDTOList")
    List<IncomeDTO> mapToIncomeDTOList(Set<IncomeEntity> incomeEntities);

}
