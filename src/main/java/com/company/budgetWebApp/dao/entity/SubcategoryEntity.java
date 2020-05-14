package com.company.budgetWebApp.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name="subcategories")
@Embeddable
public class SubcategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @Embedded
    private CategoryEntity category;

    @OneToMany
    @JoinColumn(name = "subcategory_id")
    @ElementCollection
    @OrderBy("date ASC")
    private Set<ExpenseEntity> expenses;

    @OneToMany
    @JoinColumn(name = "subcategory_id")
    @ElementCollection
    @OrderBy("date ASC")
    private Set<IncomeEntity> incomes;

    public SubcategoryEntity() {

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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public Set<ExpenseEntity> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<ExpenseEntity> expenses) {
        this.expenses = expenses;
    }

    public Set<IncomeEntity> getIncomes() {
        return incomes;
    }

    public void setIncomes(Set<IncomeEntity> incomes) {
        this.incomes = incomes;
    }

    @Override
    public String toString() {
        return "SubcategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}

