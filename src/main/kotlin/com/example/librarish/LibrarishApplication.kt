package com.example.librarish

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
class LibrarishApplication

fun main(args: Array<String>) {
    runApplication<LibrarishApplication>(*args)
}
