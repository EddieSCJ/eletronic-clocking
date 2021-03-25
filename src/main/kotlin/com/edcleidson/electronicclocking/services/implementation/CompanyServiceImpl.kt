package com.edcleidson.electronicclocking.services.implementation

import com.edcleidson.electronicclocking.domain.Company
import com.edcleidson.electronicclocking.repositories.CompanyRepository
import com.edcleidson.electronicclocking.services.CompanyService
import org.springframework.stereotype.Service

@Service
class CompanyServiceImpl(val companyRepository: CompanyRepository) : CompanyService {

    override fun findByCnpj(cnpj: String): Company? = companyRepository.findByCnpj(cnpj)

    override fun save(company: Company): Company = companyRepository.save(company)
}