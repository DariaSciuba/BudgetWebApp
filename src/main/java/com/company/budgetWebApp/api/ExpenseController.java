package com.company.budgetWebApp.api;

import com.company.budgetWebApp.manager.ExpenseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("app/expense")
public class ExpenseController {

    private final ExpenseManager expenseManager;

    @Autowired
    public ExpenseController(ExpenseManager expenseManager) {
        this.expenseManager = expenseManager;
    }

    @GetMapping("/list")
    public String getExpenses(Model model) {
        model.addAttribute("expenses", expenseManager.findAll());
        return "expenses";
    }
}
