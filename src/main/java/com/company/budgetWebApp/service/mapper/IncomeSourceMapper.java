package com.company.budgetWebApp.service.mapper;

import com.company.budgetWebApp.dao.entity.IncomeSourceEntity;
import com.company.budgetWebApp.service.dto.IncomeSourceDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {IncomeMapper.class})
public interface IncomeSourceMapper {

    @Mapping(target="incomes", source="incomesDTO", qualifiedByName ="mapToIncomeList")
    IncomeSourceEntity incomeSourceDtoToEntity(IncomeSourceDTO incomeSourceDTO);

    @Mapping(target="incomesDTO", source="incomes", qualifiedByName ="mapToIncomeDTOList")
    IncomeSourceDTO incomeSourceEntityToDto(IncomeSourceEntity incomeSourceEntity);

    @Named("mapToIncomeSourceList")
    List<IncomeSourceEntity> mapToIncomeSourceList(List<IncomeSourceDTO> incomeSourceDTOS);

    @Named("mapToIncomeSourceDTOList")
    List<IncomeSourceDTO> mapToIncomeSourceDtoList(List<IncomeSourceEntity> incomeSourceEntities);
}
