package com.example.librarish.entities

import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import java.util.*


@MappedSuperclass
class UUIDEntity(
    @Id
    var id: UUID = UUID.randomUUID()
)