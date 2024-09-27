package com.example.librarish.entities

import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.util.*


@MappedSuperclass
class UUIDEntity(
    @Id @JdbcTypeCode(SqlTypes.UUID)
    val id: UUID = UUID.randomUUID()
)