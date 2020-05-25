package com.company.budgetWebApp.service.dto;

import java.util.List;

public class IncomeSourceDTO {

    private Long id;
    private String companyName;
    private String companyAddress;
    private List<IncomeDTO> incomesDTO;

    public IncomeSourceDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public List<IncomeDTO> getIncomesDTO() {
        return incomesDTO;
    }

    public void setIncomesDTO(List<IncomeDTO> incomesDTO) {
        this.incomesDTO = incomesDTO;
    }
}
