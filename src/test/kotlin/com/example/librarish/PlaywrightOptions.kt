package com.example.librarish

import com.microsoft.playwright.junit.Options
import com.microsoft.playwright.junit.OptionsFactory

class PlaywrightOptions : OptionsFactory {
    override fun getOptions(): Options {
        return Options()
            .setChannel("msedge")
            .setBaseUrl("http://localhost:8080")
    }
}