package com.company.budgetWebApp.api;

import com.company.budgetWebApp.dao.entity.AccountEntity;
import com.company.budgetWebApp.dao.entity.ExpenseEntity;
import com.company.budgetWebApp.dao.entity.SubcategoryEntity;
import com.company.budgetWebApp.service.AccountService;
import com.company.budgetWebApp.service.dto.AccountDTO;
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
    private final AccountService accountService;

    @Autowired
    public ExpenseController(ExpenseService expenseService, SubcategoryService subcategoryService, AccountService accountService) {
        this.expenseService = expenseService;
        this.subcategoryService = subcategoryService;
        this.accountService = accountService;
    }

    @GetMapping("/list")
    public String getExpenses(Model model) {
        model.addAttribute("expenses", expenseService.findAllExpensesForDate());
        model.addAttribute("newExpenseDto", new ExpenseDTO());
        return "appExpensesList";
    }

    @PostMapping("/add")
    public String addExpenseProcess(@ModelAttribute("newExpenseDto") @Valid ExpenseDTO expenseDTO) {
        ExpenseEntity expenseEntity = expenseService.mapExpenseDtoToEntity(expenseDTO);
        SubcategoryEntity subcategoryEntity = subcategoryService.findById(expenseDTO.getSubcategoryDTO().getId()).get();
        AccountEntity accountEntity = accountService.findById(expenseDTO.getAccountDTO().getId()).get();

        expenseEntity.setSubcategory(subcategoryEntity);
        expenseEntity.setAccount(accountEntity);

        expenseService.save(expenseEntity);
        return "redirect:/app/expense/list";
    }

    @ModelAttribute("subcategories")
    private List<SubcategoryDTO> fetchSubcategoriesToDto() {
        return subcategoryService.mapSubcategoryListEntityToDto(subcategoryService.findSubcategoriesExpenses());
    }

    @ModelAttribute("accounts")
    private List<AccountDTO> fetchAccountsToDto() {
        return accountService.mapAccountListEtityToDto(accountService.findAll());
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteById(id);
        return "redirect:/app/expense/list";
    }

    @GetMapping("/edit/{id}")
    public String editExpense(@PathVariable Long id, Model model) {
        ExpenseEntity expenseEntity = expenseService.findById(id).get();
        ExpenseDTO expenseDTO = expenseService.mapExpenseEntityToDto(expenseEntity);
        model.addAttribute("expenseDTO", expenseDTO);
        return "appEditExpense";
    }

    @PostMapping("/edit/{id}")
    public String editExpenseProcessForm(@PathVariable Long id, @ModelAttribute("expenseDTO") @Valid ExpenseDTO expenseDTO) {
        ExpenseEntity expenseEntity = expenseService.mapExpenseDtoToEntity(expenseDTO);
        SubcategoryEntity subcategoryEntity = subcategoryService.findById(expenseDTO.getSubcategoryDTO().getId()).get();
        AccountEntity accountEntity = accountService.findById(expenseDTO.getAccountDTO().getId()).get();

        expenseEntity.setSubcategory(subcategoryEntity);
        expenseEntity.setAccount(accountEntity);

        expenseService.save(expenseEntity);
        return "redirect:/app/expense/list";
    }

}
