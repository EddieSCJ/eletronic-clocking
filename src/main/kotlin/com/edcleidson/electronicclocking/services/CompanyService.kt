package com.edcleidson.electronicclocking.services

import com.edcleidson.electronicclocking.domain.Company

interface CompanyService {

    fun findByCnpj(cnpj : String): Company?

    fun save(company: Company): Company

}