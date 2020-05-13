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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("incomes", incomeService.findAll());
        return "appIncomesList";
    }

    @GetMapping("/add")
    public String addIncome(Model model) {
        model.addAttribute("newIncomeDto", new IncomeDTO());
        return "appAddIncome";
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

}

