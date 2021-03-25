package com.edcleidson.electronicclocking.domain

import com.edcleidson.electronicclocking.domain.enums.Role
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Employee(
    val nome: String,
    val email: String,
    val password: String,
    val cpf: String,
    val role: Role,
    val companyId: String,
    val hourPrice: Double? = 0.0,
    val defaultWorkTime: Float? = 0.0f,
    val defaultLunchTime: Float? = 0.0f,
    @Id val id: String? = null
)
