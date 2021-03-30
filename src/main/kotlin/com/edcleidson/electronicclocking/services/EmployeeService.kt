package com.edcleidson.electronicclocking.services

import com.edcleidson.electronicclocking.domain.Employee
import org.springframework.data.domain.Page

interface EmployeeService {

    fun findAll(page: Int, quantityPerPage: Int, order: String, direction: String): Page<Employee>

    fun findByIdOrCpfOrEmail(id: String, cpf: String, email: String): Employee?

    fun findById(id: String): Employee?

    fun findByCpf(cpf: String) : Employee?

    fun findByEmail(email: String) : Employee?

    fun save(employee: Employee): Employee

    fun employeeExists(employee: Employee?) : Boolean

    fun deleteById(id: String): Boolean

}