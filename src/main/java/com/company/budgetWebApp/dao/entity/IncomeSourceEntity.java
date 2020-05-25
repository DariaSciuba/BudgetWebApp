package com.company.budgetWebApp.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "income_sources")
public class IncomeSourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String companyName;

    private String companyAddress;

    @OneToMany
    @JoinColumn (name = "income_source_id")
    private List<IncomeEntity> incomes;

    public IncomeSourceEntity() {
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

    public List<IncomeEntity> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<IncomeEntity> incomes) {
        this.incomes = incomes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeSourceEntity that = (IncomeSourceEntity) o;
        return id.equals(that.id) &&
                companyName.equals(that.companyName) &&
                Objects.equals(companyAddress, that.companyAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, companyAddress);
    }

    @Override
    public String toString() {
        return "IncomeSourceEntity{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                '}';
    }
}
