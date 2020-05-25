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
    @Mapping(target = "account", source = "accountDTO")
    @Mapping(target = "incomeSource", source = "incomeSourceDTO")
    IncomeEntity incomeDtoToEntity(IncomeDTO incomeDTO);

    @InheritInverseConfiguration
    @Mapping(target = "subcategoryDTO.incomesDTO", ignore = true)
    @Mapping(target = "accountDTO.incomesDTO", ignore = true)
    @Mapping(target = "incomeSourceDTO.incomesDTO", ignore = true)
    IncomeDTO incomeEntityToDto(IncomeEntity incomeEntity);

    @Named("mapToIncomeList")
    List<IncomeEntity> mapToIncomeList(List<IncomeDTO> incomeDTOS);

    @Named("mapToIncomeDTOList")
    List<IncomeDTO> mapToIncomeDTOList(Set<IncomeEntity> incomeEntities);

}
