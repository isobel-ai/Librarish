package com.example.librarish.frontendTests

import com.example.librarish.PlaywrightOptions
import com.microsoft.playwright.Page
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import com.microsoft.playwright.junit.UsePlaywright
import com.microsoft.playwright.options.AriaRole
import org.junit.jupiter.api.Test

@UsePlaywright(PlaywrightOptions::class)
class LoginPageTest {

    @Test
    fun `loginPage has correct initial elements`(page: Page) {
        page.navigate("/");
        assertThat(page.getByRole(AriaRole.HEADING)).containsText("Sign In");
        assertThat(page.locator("#loginForm")).containsText("Name");
        assertThat(page.locator("#name")).hasValue("");
        assertThat(page.locator("#loginForm")).containsText("Password");
        assertThat(page.locator("#password")).hasValue("");
        assertThat(page.locator("#show-password-button")).containsText("Show");
        assertThat(page.locator("#loginForm")).containsText("Account Type");
        assertThat(page.locator("#accountType")).containsText("LIBRARY MEMBER");
        assertThat(page.locator("#accountType")).hasValue("LIBRARY");
        assertThat(page.locator("#loginButton")).containsText("Sign In");
        assertThat(page.locator("#errorMessage")).containsText("");
    }

    @Test
    fun `#show-password-button toggles #password type`(page: Page) {
        page.navigate("/");
        assertThat(page.locator("#password")).hasAttribute("type", "password");
        page.locator("#show-password-button").click();
        assertThat(page.locator("#password")).hasAttribute("type", "text");
        page.locator("#show-password-button").click();
        assertThat(page.locator("#password")).hasAttribute("type", "password");
    }

    @Test
    fun `#login-button is enabled iff #name and #password aren't empty`(page: Page) {
        page.navigate("/");
        assertThat(page.locator("#loginButton")).isDisabled();

        page.locator("#name").fill("n");
        assertThat(page.locator("#loginButton")).isDisabled();

        page.locator("#name").clear();
        page.locator("#password").fill("p");
        assertThat(page.locator("#loginButton")).isDisabled();

        page.locator("#name").fill("n");
        assertThat(page.locator("#loginButton")).isEnabled();
    }
}