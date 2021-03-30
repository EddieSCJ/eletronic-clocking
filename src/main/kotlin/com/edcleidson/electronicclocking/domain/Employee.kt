package com.edcleidson.electronicclocking.domain

import com.edcleidson.electronicclocking.domain.dto.EmployeeDTO
import com.edcleidson.electronicclocking.domain.enums.Role
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Employee(
    val name: String,
    val email: String,
    val password: Password,
    val cpf: String,
    val role: Role,
    val companyId: String,
    val hourPrice: Double? = 0.0,
    val defaultWorkTime: Float? = 0.0f,
    val defaultLunchTime: Float? = 0.0f,
    val id: String? = null
) {
    companion object {
        fun fromDto(employeeDTO: EmployeeDTO): Employee {
            return Employee(
                name = employeeDTO.name,
                email = employeeDTO.email,
                password = Password(employeeDTO.password),
                cpf = employeeDTO.cpf,
                role = Role.toEnum(employeeDTO.role),
                companyId = employeeDTO.companyId,
                hourPrice = employeeDTO.hourPrice,
                defaultWorkTime = employeeDTO.defaultWorkTime,
                defaultLunchTime = employeeDTO.defaultLunchTime,
                id = employeeDTO.id
            )
        }
    }
}
