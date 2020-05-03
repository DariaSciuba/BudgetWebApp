package com.company.budgetWebApp.api;

import com.company.budgetWebApp.dao.entity.CategoryEntity;
import com.company.budgetWebApp.dto.CategoryDTO;
import com.company.budgetWebApp.manager.CategoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/app/category")
public class CategoryController {

    private CategoryManager categoryManager;

    @Autowired
    public CategoryController(CategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        model.addAttribute("categories", categoryManager.findAll());
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
        if(result.hasErrors()) {
            return "appAddCategory";
        } else {
            CategoryEntity categoryEntity = categoryManager.mapCategoryDtoToEntity(categoryDTO);
            categoryManager.save(categoryEntity);
            return "redirect:/app/category/list";
        }
    }
}
