package com.example.librarish.controllers

import com.example.librarish.formModels.LoginForm
import com.example.librarish.services.LoginService
import com.example.librarish.types.AccountType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class LoginController(
    private val loginService: LoginService
) {

    @GetMapping("/")
    fun getLoginPage(model: Model): String {
        model.addAttribute("loginForm", LoginForm())
        return "pages/loginPage"
    }

    @PostMapping("/")
    fun loginPage(model: Model, loginForm: LoginForm): String {
        try {
            if (loginService.accountExists(loginForm)) {
                return "redirect:/home/${loginForm.accountType}/${loginForm.name}"
            }
            model.addAttribute("errorMessage", "Invalid details.")
        } catch (e: Exception) {
            model.addAttribute(
                "errorMessage",
                "This request cannot be processed at the moment. Please try again later."
            )
        }
        return "pages/loginPage"
    }

    @ModelAttribute
    fun addAccountOptions(model: Model) {
        model.addAttribute("options", AccountType.entries.toTypedArray())
    }
}