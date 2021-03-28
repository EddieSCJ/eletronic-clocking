package com.edcleidson.electronicclocking.repositories

import com.edcleidson.electronicclocking.domain.Company
import org.springframework.data.mongodb.repository.MongoRepository

interface CompanyRepository : MongoRepository<Company, String> {

    fun findByCnpj(cpnj: String) : Company?

    fun findByIdOrSocialNameOrCnpj(id: String?, socialName: String, cnpj: String): Company?
}