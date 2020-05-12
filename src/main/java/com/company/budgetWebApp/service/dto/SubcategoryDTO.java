package com.company.budgetWebApp.service.dto;

import java.util.List;

public class SubcategoryDTO {

    private Long id;
    private String subcategoryName;
    private CategoryDTO categoryDTO;
    private List<ExpenseDTO> expensesDTO;
    private List<IncomeDTO> incomesDTO;

    public SubcategoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public List<ExpenseDTO> getExpensesDTO() {
        return expensesDTO;
    }

    public void setExpensesDTO(List<ExpenseDTO> expensesDTO) {
        this.expensesDTO = expensesDTO;
    }

    public List<IncomeDTO> getIncomesDTO() {
        return incomesDTO;
    }

    public void setIncomesDTO(List<IncomeDTO> incomesDTO) {
        this.incomesDTO = incomesDTO;
    }
}
