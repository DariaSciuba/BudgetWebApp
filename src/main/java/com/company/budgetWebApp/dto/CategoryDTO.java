package com.company.budgetWebApp.dto;

import com.company.budgetWebApp.dao.entity.SubcategoryEntity;

import java.util.Set;

public class CategoryDTO {

    private Long id;
    private String name;
    private String type;
    private Set<SubcategoryDTO> subcategories;

    public CategoryDTO() {

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

    public String getType() {
        return type;
    }

    public void setType(String type) { this.type = type;
    }

    public Set<SubcategoryDTO> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set<SubcategoryDTO> subcategories) {
        this.subcategories = subcategories;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
