package com.edcleidson.electronicclocking.repositories

import com.edcleidson.electronicclocking.domain.Employee
import org.springframework.data.mongodb.repository.MongoRepository

interface EmployeeRepository : MongoRepository<Employee, String> {

    fun findByIdOrCpfOrEmail(id: String?, cpf: String?, email: String?): Employee?

    fun findByCpf(cpf: String) : Employee?

    fun findByEmail(email: String?) : Employee?
}