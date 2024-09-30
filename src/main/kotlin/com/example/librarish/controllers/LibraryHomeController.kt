package com.example.librarish.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class LibraryHomeController {

    @GetMapping("/{name}/libraryHome/")
    fun getLibraryHomePage(model: Model, @PathVariable name: String): String {
        model.addAttribute("name", name)
        return "pages/libraryHomePage"
    }
}