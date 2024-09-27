package com.example.librarish.formModels

import com.example.librarish.types.AccountType

class LoginForm() {
    var name: String? = null
    var password: String? = null
    var accountType: AccountType = AccountType.LIBRARY

    constructor(name: String, password: String, accountType: AccountType) : this() {
        this.name = name
        this.password = password
        this.accountType = accountType
    }
}