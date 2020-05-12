package com.company.budgetWebApp.service;

import com.company.budgetWebApp.dao.entity.IncomeEntity;
import com.company.budgetWebApp.dao.repository.IncomeRepository;
import com.company.budgetWebApp.service.dto.IncomeDTO;
import com.company.budgetWebApp.service.mapper.IncomeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    private IncomeRepository incomeRepository;
    private IncomeMapper incomeMapper;

    public IncomeService(IncomeRepository incomeRepository, IncomeMapper incomeMapper) {
        this.incomeRepository = incomeRepository;
        this.incomeMapper = incomeMapper;
    }

   public IncomeEntity mapIncomeDtoToEntity(IncomeDTO incomeDTO) {
        return incomeMapper.incomeDtoToEntity(incomeDTO);
   }

   public IncomeDTO mapIncomeEntityToDto(IncomeEntity incomeEntity) {
        return incomeMapper.incomeEntityToDto(incomeEntity);
    }

    public Optional<IncomeEntity> findById(Long id) { return incomeRepository.findById(id); }

    public List<IncomeEntity> findAll() { return incomeRepository.findAll(); }

    public IncomeEntity save(IncomeEntity incomeEntity) { return incomeRepository.save(incomeEntity); }

    public void deleteById(Long id) { incomeRepository.deleteById(id); }
}
