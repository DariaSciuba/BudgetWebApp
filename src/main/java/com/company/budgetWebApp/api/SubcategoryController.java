package com.company.budgetWebApp.api;

import com.company.budgetWebApp.dao.entity.CategoryEntity;
import com.company.budgetWebApp.dao.entity.SubcategoryEntity;
import com.company.budgetWebApp.dto.CategoryDTO;
import com.company.budgetWebApp.dto.SubcategoryDTO;
import com.company.budgetWebApp.manager.CategoryManager;
import com.company.budgetWebApp.manager.SubcategoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/app/subcategory")
public class SubcategoryController {

    private final SubcategoryManager subcategoryManager;
    private final CategoryManager categoryManager;

    @Autowired
    public SubcategoryController(SubcategoryManager subcategoryManager, CategoryManager categoryManager) {
        this.subcategoryManager = subcategoryManager;
        this.categoryManager = categoryManager;
    }

    @GetMapping("/list")
    public String getSubcategories(Model map) {
        map.addAttribute("subcategories", subcategoryManager.findAll());
        return "subcategories";
    }


    @GetMapping("/add")
    public String addSubcategory(Model model) {
        model.addAttribute("newSubcategoryDto", new SubcategoryDTO());
        return "appAddSubcategory";
    }

    @PostMapping("/add")
    public String addSubcategoryProcess(@ModelAttribute("newSubcategoryDto") @Valid SubcategoryDTO subcategoryDTO) {
            SubcategoryEntity subcategoryEntity = subcategoryManager.mapSubcategoryDtoToEntity(subcategoryDTO);
            CategoryEntity categoryEntity = categoryManager.findById(subcategoryDTO.getCategory().getId()).get();
            subcategoryEntity.setCategory(categoryEntity);
            subcategoryManager.save(subcategoryEntity);
            return "redirect:/app/subcategory/list";
    }

    @ModelAttribute("categories")
    private List<CategoryDTO> fetchCategoriesToDto() {
        return categoryManager.mapCategoryListEntityToDto(categoryManager.findAll());
    }

}
