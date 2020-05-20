package com.company.budgetWebApp.api;

import com.company.budgetWebApp.dao.entity.CategoryEntity;
import com.company.budgetWebApp.service.SubcategoryService;
import com.company.budgetWebApp.service.dto.CategoryDTO;
import com.company.budgetWebApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/app/category")
public class CategoryController {

    private CategoryService categoryService;
    private SubcategoryService subcategoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public void findAll(Model model) {
        model.addAttribute("categories", categoryService.findAll());
    }

    @PostMapping("/add")
    public String addCategoryProcess(@ModelAttribute("newCategoryDto") @Valid CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryService.mapCategoryDtoToEntity(categoryDTO);
        categoryService.save(categoryEntity);
        return "redirect:/app/subcategory/customize";
    }

    @ModelAttribute("newCategoryDTO")
    private void newCategoryDTO(Model model) {
        model.addAttribute("newCategoryDto", new CategoryDTO());
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id, Model model) {
        categoryService.deleteById(id);
        return "redirect:/app/subcategory/customize";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model) {
        CategoryEntity categoryEntity = categoryService.findById(id).get();
        CategoryDTO categoryDTO = categoryService.mapCategoryEntityToDto(categoryEntity);
        model.addAttribute("categoryDTO",categoryDTO);
        return "appEditCategory";
    }

    @PostMapping("/edit/{id}")
    public String editCategoryProcessForm(@PathVariable Long id, @ModelAttribute("categoryDTO") @Valid CategoryDTO categoryDTO) {
       CategoryEntity categoryEntity = categoryService.mapCategoryDtoToEntity(categoryDTO);
       categoryService.save(categoryEntity);
        return "redirect:/app/subcategory/customize";
    }

}
