package com.example.librarish.integrationTests

import com.example.librarish.PlaywrightOptions
import com.example.librarish.repositories.LibraryRepository
import com.microsoft.playwright.Page
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import com.microsoft.playwright.junit.UsePlaywright
import io.mockk.mockk
import org.junit.jupiter.api.Test
import java.util.regex.Pattern

@UsePlaywright(PlaywrightOptions::class)
class LoginIntegrationTest {
    val libraryMockRepository: LibraryRepository = mockk()

    @Test
    fun `loginPage returns libraryHomePage when valid library login`(page: Page) {
        val name = "TestLibrary"
        page.navigate("/");
        page.locator("#name").fill(name);
        page.locator("#password").fill("test");
        page.locator("#loginButton").click();
        assertThat(page).hasURL(Pattern.compile("/$name/libraryHome"))
    }

    @Test
    fun `loginPage returns loginPage with 'Invalid details' error message when invalid library login`(page: Page) {
        page.navigate("/");
        page.locator("#name").fill("invalid");
        page.locator("#password").fill("test");
        page.locator("#loginButton").click();
        assertThat(page.locator("#errorMessage")).containsText("Invalid details.");
    }
}