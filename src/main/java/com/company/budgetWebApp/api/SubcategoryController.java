package com.company.budgetWebApp.api;

import com.company.budgetWebApp.dao.entity.CategoryEntity;
import com.company.budgetWebApp.dao.entity.ExpenseEntity;
import com.company.budgetWebApp.dao.entity.IncomeEntity;
import com.company.budgetWebApp.dao.entity.SubcategoryEntity;
import com.company.budgetWebApp.service.dto.CategoryDTO;
import com.company.budgetWebApp.service.dto.SubcategoryDTO;
import com.company.budgetWebApp.service.CategoryService;
import com.company.budgetWebApp.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/app/subcategory")
public class SubcategoryController {

    private final SubcategoryService subcategoryService;
    private final CategoryService categoryService;

    @Autowired
    public SubcategoryController(SubcategoryService subcategoryService, CategoryService categoryService) {
        this.subcategoryService = subcategoryService;
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public void getSubcategories(Model model) {
        model.addAttribute("subcategories", subcategoryService.findAll());
    }

    @GetMapping("/customize")
    public String customizeTable(Model model) {
        model.addAttribute("newCategoryDto", new CategoryDTO());
        model.addAttribute("newSubcategoryDto", new SubcategoryDTO());
        return "appCustomizeTable";
    }

    @PostMapping("/add")
    public String addSubcategoryProcess(@ModelAttribute("newSubcategoryDto") @Valid SubcategoryDTO subcategoryDTO) {
            SubcategoryEntity subcategoryEntity = subcategoryService.mapSubcategoryDtoToEntity(subcategoryDTO);
            CategoryEntity categoryEntity = categoryService.findById(subcategoryDTO.getCategoryDTO().getId()).get();
            subcategoryEntity.setCategory(categoryEntity);
            subcategoryService.save(subcategoryEntity);
            return "redirect:/app/subcategory/customize";
    }

    @ModelAttribute("categories")
    private List<CategoryDTO> fetchCategoriesToDto() {
        return categoryService.mapCategoryListEntityToDto(categoryService.findAll());
    }

    @GetMapping("/delete/{id}")
    public String deleteSubcategory(@PathVariable Long id) {
        subcategoryService.deleteById(id);
        return "redirect:/app/subcategory/customize";
    }

    @GetMapping("/edit/{id}")
    public String editSubcategory(@PathVariable Long id, Model model) {
        SubcategoryEntity subcategoryEntity = subcategoryService.findById(id).get();
        SubcategoryDTO subcategoryDTO = subcategoryService.mapSubcategoryEntityToDto(subcategoryEntity);
        model.addAttribute("subcategoryDTO", subcategoryDTO);
        return "appEditSubcategory";
    }

    @PostMapping("/edit/{id}")
    public String editSubcategoryProcessForm(@PathVariable Long id,
                                             @ModelAttribute("subcategoryDTO") @Valid SubcategoryDTO subcategoryDTO) {
        SubcategoryEntity subcategoryEntity = subcategoryService.mapSubcategoryDtoToEntity(subcategoryDTO);
        List<IncomeEntity> incomes = subcategoryService.findById(id).get().getIncomes();
        subcategoryEntity.setIncomes(incomes);
        List<ExpenseEntity> expenses = subcategoryService.findById(id).get().getExpenses();
        subcategoryEntity.setExpenses(expenses);
        subcategoryService.save(subcategoryEntity);
        return "redirect:/app/subcategory/customize";
    }

}


