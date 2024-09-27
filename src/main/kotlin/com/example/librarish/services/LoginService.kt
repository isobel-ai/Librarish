package com.example.librarish.services

import com.example.librarish.formModels.LoginForm
import com.example.librarish.repositories.LibraryRepository
import com.example.librarish.types.AccountType
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val libraryRepository: LibraryRepository
) {
    fun accountExists(loginForm: LoginForm): Boolean {
        return when (loginForm.accountType) {
            AccountType.LIBRARY -> libraryRepository.existsByNameAndPassword(loginForm.name!!, loginForm.password!!)
            AccountType.MEMBER -> false
        }
    }
}