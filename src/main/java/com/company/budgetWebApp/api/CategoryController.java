package com.company.budgetWebApp.api;

import com.company.budgetWebApp.dao.entity.CategoryEntity;
import com.company.budgetWebApp.service.dto.CategoryDTO;
import com.company.budgetWebApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/app/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categories";
    }

    @GetMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("newCategoryDto", new CategoryDTO());
        return "appAddCategory";
    }

    @PostMapping("/add")
    public String addCategoryProcess(@ModelAttribute("newCategoryDto") @Valid CategoryDTO categoryDTO,
                                     BindingResult result) {
        CategoryEntity categoryEntity = categoryService.mapCategoryDtoToEntity(categoryDTO);
        categoryService.save(categoryEntity);
        return "redirect:/app/category/list";
    }
}
