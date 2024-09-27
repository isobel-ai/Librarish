package com.example.librarish.repositories

import com.example.librarish.entities.Library
import org.springframework.data.repository.CrudRepository
import java.util.*

interface LibraryRepository : CrudRepository<Library, UUID> {
    fun existsByNameAndPassword(name: String, password: String): Boolean
}