package com.edcleidson.electronicclocking.services

import com.edcleidson.electronicclocking.domain.Company
import com.edcleidson.electronicclocking.repositories.CompanyRepository
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class CompanyServiceTest {

    @Autowired
    private val companyService: CompanyService? = null

    @MockBean
    private val companyRepository: CompanyRepository? = null

    private val CNPJ: String = "12021034578212"
    private val WRONG_CNPJ = "28748213478884"

    @BeforeEach
    @Throws(Exception::class)
    fun setUp() {

        BDDMockito.given(companyRepository?.findByCnpj(CNPJ)).willReturn(company())
        BDDMockito.given(companyRepository?.save(company())).willReturn(company())
    }

    @Test
    fun shouldFindCompanyByCnpj() {
        val company: Company? = companyService?.findByCnpj(CNPJ)
        assertNotNull(company)
    }

    @Test
    fun shouldReturnNullWhenFindCompanyByWrongCnpj() {
        val company: Company? = companyService?.findByCnpj(WRONG_CNPJ)
        assertNull(company)
    }

    @Test
    fun shouldSaveAndReturnACompany() {
        val company: Company? = companyService?.save(company())
        assertNotNull(company)
    }

    private fun company(): Company = Company("The Coca Cola LTDA", CNPJ, "29wjdf89wdu13414")

}