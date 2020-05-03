package com.company.budgetWebApp.dto;

import java.util.Set;

public class SubcategoryDTO {

    private Long id;
    private String name;
    private CategoryDTO category;
    private Set<ExpenseDTO> expenses;

    public SubcategoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public Set<ExpenseDTO> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<ExpenseDTO> expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "SubcategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
