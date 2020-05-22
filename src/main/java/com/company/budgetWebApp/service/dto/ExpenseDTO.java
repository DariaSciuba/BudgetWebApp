package com.company.budgetWebApp.service.dto;

public class ExpenseDTO {

    private Long id;
    private String dateDTO;
    private SubcategoryDTO subcategoryDTO;
    private double amount;
    private String note;
    private AccountDTO accountDTO;

    public ExpenseDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateDTO() {
        return dateDTO;
    }

    public void setDateDTO(String dateDTO) {
        this.dateDTO = dateDTO;
    }

    public SubcategoryDTO getSubcategoryDTO() {
        return subcategoryDTO;
    }

    public void setSubcategoryDTO(SubcategoryDTO subcategoryDTO) {
        this.subcategoryDTO = subcategoryDTO;
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

    public AccountDTO getAccountDTO() {
        return accountDTO;
    }

    public void setAccountDTO(AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
    }
}
