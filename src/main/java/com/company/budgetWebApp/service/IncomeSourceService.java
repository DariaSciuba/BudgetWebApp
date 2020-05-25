package com.company.budgetWebApp.service;

import com.company.budgetWebApp.dao.entity.IncomeSourceEntity;
import com.company.budgetWebApp.dao.repository.IncomeSourceRepository;
import com.company.budgetWebApp.service.dto.IncomeSourceDTO;
import com.company.budgetWebApp.service.mapper.IncomeSourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeSourceService {

    private IncomeSourceRepository incomeSourceRepository;
    private IncomeSourceMapper incomeSourceMapper;

    @Autowired
    public IncomeSourceService(IncomeSourceRepository incomeSourceRepository, IncomeSourceMapper incomeSourceMapper) {
        this.incomeSourceRepository = incomeSourceRepository;
        this.incomeSourceMapper = incomeSourceMapper;
    }

    public IncomeSourceEntity mapIncomeSourceDtoToEntity(IncomeSourceDTO incomeSourceDTO) {
        return incomeSourceMapper.incomeSourceDtoToEntity(incomeSourceDTO);
    }

    public IncomeSourceDTO mapIncomeSourceEntityToDto(IncomeSourceEntity incomeSourceEntity) {
        return incomeSourceMapper.incomeSourceEntityToDto(incomeSourceEntity);
    }

    public List<IncomeSourceDTO> mapToIncomeSourceDtoList(List<IncomeSourceEntity> incomeSourceEntities) {
        return incomeSourceMapper.mapToIncomeSourceDtoList(incomeSourceEntities);
    }

    public Optional<IncomeSourceEntity> findById(Long id) { return incomeSourceRepository.findById(id); }

    public List<IncomeSourceEntity> findAll() { return incomeSourceRepository.findAll(); }

    public IncomeSourceEntity save(IncomeSourceEntity incomeSourceEntity) {
        return incomeSourceRepository.save(incomeSourceEntity);
    }

    public void deleteById(Long id) { incomeSourceRepository.deleteById(id);}

    public boolean existedById(Long id) { return incomeSourceRepository.existsById(id); }

}
