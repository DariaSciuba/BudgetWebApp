package com.company.budgetWebApp.service.dto;

import java.util.List;

public class AccountDTO {

    private Long id;
    private String accountNumber;
    private String accountType;
    private String bankName;
    private String currency;
    private double balanceDTO;
    private List<IncomeDTO> incomesDTO;
    private List<ExpenseDTO> expensesDTO;

    public AccountDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalanceDTO() {
        return balanceDTO;
    }

    public void setBalanceDTO(double balanceDTO) {
        this.balanceDTO = balanceDTO;
    }

    public List<IncomeDTO> getIncomesDTO() {
        return incomesDTO;
    }

    public void setIncomesDTO(List<IncomeDTO> incomesDTO) {
        this.incomesDTO = incomesDTO;
    }

    public List<ExpenseDTO> getExpensesDTO() {
        return expensesDTO;
    }

    public void setExpensesDTO(List<ExpenseDTO> expensesDTO) {
        this.expensesDTO = expensesDTO;
    }
}
