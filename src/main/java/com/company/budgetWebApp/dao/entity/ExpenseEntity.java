package com.company.budgetWebApp.dao.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "expenses")
public class ExpenseEntity {

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

    public ExpenseEntity() {

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

    @Override
    public String toString() {
        return "ExpenseEntity{" +
                "id=" + id +
                ", date=" + date +
                ", subcategory=" + subcategory +
                ", amount=" + amount +
                ", note='" + note + '\'' +
                '}';
    }

}
