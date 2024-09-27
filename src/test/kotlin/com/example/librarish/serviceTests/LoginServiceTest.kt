package com.example.librarish.serviceTests

import com.example.librarish.formModels.LoginForm
import com.example.librarish.repositories.LibraryRepository
import com.example.librarish.services.LoginService
import com.example.librarish.types.AccountType
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


class LoginServiceTest {
    val libraryMockRepository: LibraryRepository = mockk()
    val loginService = LoginService(libraryMockRepository)

    @Test
    fun `accountExists returns true when Library account exists`() {
        every { libraryMockRepository.existsByNameAndPassword("user", "pass") } returns true

        val accountExists = loginService.accountExists(LoginForm("user", "pass", AccountType.LIBRARY))

        verify(exactly = 1) { libraryMockRepository.existsByNameAndPassword("user", "pass") }
        assertTrue(accountExists)
    }

    @Test
    fun `accountExists returns false when Library account doesn't exist`() {
        every { libraryMockRepository.existsByNameAndPassword("user", "pass") } returns false

        val accountExists = loginService.accountExists(LoginForm("user", "pass", AccountType.LIBRARY))

        verify(exactly = 1) { libraryMockRepository.existsByNameAndPassword("user", "pass") }
        assertFalse(accountExists)
    }
}