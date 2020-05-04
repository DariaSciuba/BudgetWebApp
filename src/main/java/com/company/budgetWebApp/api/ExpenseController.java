package com.company.budgetWebApp.api;

import com.company.budgetWebApp.dao.entity.ExpenseEntity;
import com.company.budgetWebApp.dao.entity.SubcategoryEntity;
import com.company.budgetWebApp.dto.ExpenseDTO;
import com.company.budgetWebApp.dto.SubcategoryDTO;
import com.company.budgetWebApp.manager.ExpenseManager;
import com.company.budgetWebApp.manager.SubcategoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("app/expense")
public class ExpenseController {

    private final ExpenseManager expenseManager;
    private final SubcategoryManager subcategoryManager;

    @Autowired
    public ExpenseController(ExpenseManager expenseManager, SubcategoryManager subcategoryManager) {
        this.expenseManager = expenseManager;
        this.subcategoryManager = subcategoryManager;
    }

    @GetMapping("/list")
    public String getExpenses(Model model) {
        model.addAttribute("expenses", expenseManager.findAll());
        return "expenses";
    }

    @GetMapping("/add")
    public String addExpense(Model model) {
        model.addAttribute("newExpenseDto", new ExpenseDTO());
        return "appAddExpense";
    }

    @PostMapping("/add")
    public String addExpenseProcess(@ModelAttribute("newExpenseDto") @Valid ExpenseDTO expenseDTO) {
        ExpenseEntity expenseEntity = expenseManager.mapExpenseDtoToEntity(expenseDTO);
        SubcategoryEntity subcategoryEntity = subcategoryManager.findById(expenseDTO.getSubcategory().getId()).get();
        expenseEntity.setSubcategory(subcategoryEntity);
        expenseManager.save(expenseEntity);
        return "redirect:/app/expense/list";
    }

    @ModelAttribute("subcategories")
    private List<SubcategoryDTO> fetchSubcategoriesToDto() {
        return subcategoryManager.mapSubcategoryListEntityToDto(subcategoryManager.findAll());
    }

    @InitBinder
    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null,  new CustomDateEditor(dateFormat, true));
    }

}
