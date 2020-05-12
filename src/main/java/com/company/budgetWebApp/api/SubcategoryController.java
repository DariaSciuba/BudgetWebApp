package com.company.budgetWebApp.api;

import com.company.budgetWebApp.dao.entity.CategoryEntity;
import com.company.budgetWebApp.dao.entity.SubcategoryEntity;
import com.company.budgetWebApp.service.dto.CategoryDTO;
import com.company.budgetWebApp.service.dto.SubcategoryDTO;
import com.company.budgetWebApp.service.CategoryService;
import com.company.budgetWebApp.service.SubcategoryService;
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
    public String getSubcategories(Model model) {
        model.addAttribute("subcategories", subcategoryService.findAll());
        return "subcategories";
    }


    @GetMapping("/add")
    public String addSubcategory(Model model) {
        model.addAttribute("newSubcategoryDto", new SubcategoryDTO());
        return "appAddSubcategory";
    }

    @PostMapping("/add")
    public String addSubcategoryProcess(@ModelAttribute("newSubcategoryDto") @Valid SubcategoryDTO subcategoryDTO) {
            SubcategoryEntity subcategoryEntity = subcategoryService.mapSubcategoryDtoToEntity(subcategoryDTO);
            CategoryEntity categoryEntity = categoryService.findById(subcategoryDTO.getCategoryDTO().getId()).get();
            subcategoryEntity.setCategory(categoryEntity);
            subcategoryService.save(subcategoryEntity);
            return "redirect:/app/subcategory/list";
    }

    @ModelAttribute("categories")
    private List<CategoryDTO> fetchCategoriesToDto() {
        return categoryService.mapCategoryListEntityToDto(categoryService.findAll());
    }

}
