package com.company.budgetWebApp.api;

import com.company.budgetWebApp.dao.entity.AccountEntity;
import com.company.budgetWebApp.service.AccountService;
import com.company.budgetWebApp.service.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        model.addAttribute("accounts", accountService.findAll());
        model.addAttribute("newAccountDto", new AccountDTO());
        return "appAccountsList";
    }

    @PostMapping("/add")
    public String addAccountProcess(@ModelAttribute("newAccountDto") AccountDTO accountDTO) {
        AccountEntity accountEntity = accountService.mapAccountDtoToEntity(accountDTO);
        accountService.save(accountEntity);
        return "redirect:/app/account/list";
    }


}
