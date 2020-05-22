package com.company.budgetWebApp.dao.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "incomes")
public class IncomeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    private SubcategoryEntity subcategory;

    @Column(scale = 2)
    private double amount;

    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    private AccountEntity account;

    public IncomeEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SubcategoryEntity getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(SubcategoryEntity subcategory) {
        this.subcategory = subcategory;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeEntity that = (IncomeEntity) o;
        return Double.compare(that.amount, amount) == 0 &&
                id.equals(that.id) &&
                date.equals(that.date) &&
                subcategory.equals(that.subcategory) &&
                account.equals(that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, subcategory, amount, account);
    }

    @Override
    public String toString() {
        return "IncomeEntity{" +
                "id=" + id +
                ", date=" + date +
                ", subcategory=" + subcategory +
                ", amount=" + amount +
                ", note='" + note + '\'' +
                '}';
    }
}
