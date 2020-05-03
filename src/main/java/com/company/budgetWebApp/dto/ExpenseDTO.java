package com.company.budgetWebApp.dto;

import java.util.Date;

public class ExpenseDTO {

    private Long id;
    private Date date = new Date();
    private SubcategoryDTO subcategory;
    private double amount;
    private String note;

    public ExpenseDTO(){}

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

    public SubcategoryDTO getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(SubcategoryDTO subcategory) {
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
}
