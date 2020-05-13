package com.company.budgetWebApp.api;

import com.company.budgetWebApp.dao.entity.ExpenseEntity;
import com.company.budgetWebApp.dao.entity.SubcategoryEntity;
import com.company.budgetWebApp.service.dto.ExpenseDTO;
import com.company.budgetWebApp.service.dto.SubcategoryDTO;
import com.company.budgetWebApp.service.ExpenseService;
import com.company.budgetWebApp.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("app/expense")
public class ExpenseController {

    private final ExpenseService expenseService;
    private final SubcategoryService subcategoryService;

    @Autowired
    public ExpenseController(ExpenseService expenseService, SubcategoryService subcategoryService) {
        this.expenseService = expenseService;
        this.subcategoryService = subcategoryService;
    }

    @GetMapping("/list")
    public String getExpenses(Model model) {
        model.addAttribute("expenses", expenseService.findAll());
        return "appExpensesList";
    }

    @GetMapping("/add")
    public String addExpense(Model model) {
        model.addAttribute("newExpenseDto", new ExpenseDTO());
        return "appAddExpense";
    }

    @PostMapping("/add")
    public String addExpenseProcess(@ModelAttribute("newExpenseDto") @Valid ExpenseDTO expenseDTO) {
        ExpenseEntity expenseEntity = expenseService.mapExpenseDtoToEntity(expenseDTO);
        SubcategoryEntity subcategoryEntity = subcategoryService.findById(expenseDTO.getSubcategoryDTO().getId()).get();
        expenseEntity.setSubcategory(subcategoryEntity);
        expenseService.save(expenseEntity);
        return "redirect:/app/expense/list";
    }

    @ModelAttribute("subcategories")
    private List<SubcategoryDTO> fetchSubcategoriesToDto() {
        return subcategoryService.mapSubcategoryListEntityToDto(subcategoryService.findAll());
    }

}
