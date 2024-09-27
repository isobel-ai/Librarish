package com.example.librarish.controllers

import com.example.librarish.types.AccountType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class HomeController {

    @GetMapping("/home/{accountType}/{name}")
    fun getHomePage(model: Model, @PathVariable accountType: AccountType, @PathVariable name: String): String {
        model.addAttribute("name", name)
        return "pages/libraryHomePage" // TODO: send to homepage matching account type
    }
}