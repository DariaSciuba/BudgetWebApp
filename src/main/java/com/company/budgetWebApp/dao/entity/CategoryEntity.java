package com.company.budgetWebApp.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table (name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;
    private String type;

    @OneToMany
    @JoinColumn(name = "category_id")
    private Set<SubcategoryEntity> subcategories;

    public CategoryEntity() {

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

    public Set<SubcategoryEntity> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set<SubcategoryEntity> subcategories) {
        this.subcategories = subcategories;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}