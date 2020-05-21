package com.company.budgetWebApp.api;

import com.company.budgetWebApp.dao.entity.IncomeEntity;
import com.company.budgetWebApp.dao.entity.SubcategoryEntity;
import com.company.budgetWebApp.service.IncomeService;
import com.company.budgetWebApp.service.SubcategoryService;
import com.company.budgetWebApp.service.dto.IncomeDTO;
import com.company.budgetWebApp.service.dto.SubcategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("app/income")
public class IncomeController {

    private final IncomeService incomeService;
    private final SubcategoryService subcategoryService;

    @Autowired
    public IncomeController(IncomeService incomeService, SubcategoryService subcategoryService) {
        this.incomeService = incomeService;
        this.subcategoryService = subcategoryService;
    }

    @GetMapping("/list")
    public String getIncomes(Model model) {
        model.addAttribute("incomes", incomeService.findAllIncomesForDate());
        model.addAttribute("newIncomeDto", new IncomeDTO());
        return "appIncomesList";
    }

    @PostMapping("/add")
    public String addIncomeProcess(@ModelAttribute("newIncomeDto") @Valid IncomeDTO incomeDTO) {
        IncomeEntity incomeEntity = incomeService.mapIncomeDtoToEntity(incomeDTO);
        SubcategoryEntity subcategoryEntity = subcategoryService.findById(incomeDTO.getSubcategoryDTO().getId()).get();
        incomeEntity.setSubcategory(subcategoryEntity);
        incomeService.save(incomeEntity);
        return "redirect:/app/income/list";
    }

    @ModelAttribute("subcategories")
    private List<SubcategoryDTO> fetchSubcategoriesToDto() {
        return subcategoryService.mapSubcategoryListEntityToDto(subcategoryService.findSubcategoriesIncomes());
    }


    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        incomeService.deleteById(id);
        return "redirect:/app/income/list";
    }

    @GetMapping("/edit/{id}")
    public String editIncome(@PathVariable Long id, Model model) {
        IncomeEntity incomeEntity = incomeService.findById(id).get();
        IncomeDTO incomeDTO = incomeService.mapIncomeEntityToDto(incomeEntity);
        model.addAttribute("incomeDTO", incomeDTO);
        return "appEditIncome";
    }

    @PostMapping("/edit/{id}")
    public String editExpenseProcessForm(@PathVariable Long id, @ModelAttribute("incomeDTO") @Valid IncomeDTO incomeDTO) {
        IncomeEntity incomeEntity = incomeService.mapIncomeDtoToEntity(incomeDTO);
        SubcategoryEntity subcategoryEntity = subcategoryService.findById(incomeDTO.getSubcategoryDTO().getId()).get();
        incomeEntity.setSubcategory(subcategoryEntity);
        incomeService.save(incomeEntity);
        return "redirect:/app/income/list";
    }

}

