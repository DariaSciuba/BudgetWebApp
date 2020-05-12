package com.company.budgetWebApp.service.dto;

import java.util.List;

public class CategoryDTO {

    private Long id;
    private String categoryName;
    private String categoryType;
    private List<SubcategoryDTO> subcategoriesDTO;

    public CategoryDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public List<SubcategoryDTO> getSubcategoriesDTO() {
        return subcategoriesDTO;
    }

    public void setSubcategoriesDTO(List<SubcategoryDTO> subcategoriesDTO) {
        this.subcategoriesDTO = subcategoriesDTO;
    }
}
