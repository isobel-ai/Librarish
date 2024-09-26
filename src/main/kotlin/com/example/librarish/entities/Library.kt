package com.example.librarish.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class Library(
    @Column(nullable = false)
    val name: String,
    @Column(nullable = false)
    val password: String,
    val address: String,
    val townOrCity: String,
    val postcode: String
) : UUIDEntity()