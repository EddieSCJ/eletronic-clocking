package com.edcleidson.electronicclocking.controllers

import com.edcleidson.electronicclocking.domain.Company
import com.edcleidson.electronicclocking.domain.enums.constants.HttpResponses.NOT_FOUND
import com.edcleidson.electronicclocking.domain.enums.constants.HttpResponses.UNABLE_PERFORM_DELETE
import com.edcleidson.electronicclocking.response.Response
import com.edcleidson.electronicclocking.services.CompanyService
import com.edcleidson.electronicclocking.utils.helpers.BasicOperationsHelper.Companion.API
import com.edcleidson.electronicclocking.utils.helpers.BasicOperationsHelper.Companion.getValidatedResponseInstance
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/$API/companies")
class CompanyController(val companyService: CompanyService) {

    @Value("\${pagination.quantity_per_page}")
    private val quantityPerPage: Int = 0

    @GetMapping
    fun getAll(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "order", defaultValue = "socialName") order: String,
        @RequestParam(value = "direction", defaultValue = "ASC") direction: String
    ): ResponseEntity<*> {
        val pageResult: Page<Company> = companyService.findAll(page, quantityPerPage, order, direction)
        val response: Response<List<Company>> = Response(data = pageResult.content)

        return ResponseEntity.ok(response)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): ResponseEntity<*> {
        val response: Response<Company> = Response()
        val resultCompany: Company? = companyService.findById(id)

        if (resultCompany == null) {
            response.errors.add(NOT_FOUND.getDescription())
            response.status = NOT_FOUND.getCode()
            return ResponseEntity.status(response.status).body(response)
        }

        response.data = resultCompany
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun post(@Valid @RequestBody company: Company, result: BindingResult): ResponseEntity<Response<Company>> {
        val alreadyExists: Boolean = companyService.companyExists(company)
        val response: Response<Company> =
            getValidatedResponseInstance(alreadyExists = alreadyExists, shouldExists = false, result = result)
        val responseEntity: ResponseEntity<Response<Company>> = ResponseEntity.status(response.status).body(response)

        if (response.errors.isEmpty()) response.data = companyService.save(company)

        return responseEntity
    }

    @PutMapping("/{id}")
    fun put(
        @PathVariable id: String,
        @Valid @RequestBody company: Company,
        result: BindingResult
    ): ResponseEntity<Response<Company>> {
        val completeCompany = Company(company.socialName, company.cnpj, id)
        val findableCompany = Company("", "", id)
        val alreadyExists: Boolean = companyService.companyExists(findableCompany)
        val response: Response<Company> =
            getValidatedResponseInstance(alreadyExists = alreadyExists, shouldExists = true, result = result)

        val responseEntity: ResponseEntity<Response<Company>> = ResponseEntity.status(response.status).body(response)

        if (response.errors.isEmpty()) response.data = companyService.save(completeCompany)

        return responseEntity
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Response<*>> {
        val findableCompany = Company("", "", id)
        val alreadyExists: Boolean = companyService.companyExists(findableCompany)
        val response: Response<Company> =
            getValidatedResponseInstance(alreadyExists = alreadyExists, shouldExists = true)

        if (response.errors.isEmpty()) {
            val completeCompany = companyService.findById(id)
            val deleted: Boolean = companyService.deleteById(id)

            if (deleted) response.data = completeCompany
            else {
                response.errors.add(UNABLE_PERFORM_DELETE.getDescription())
                response.status = UNABLE_PERFORM_DELETE.getCode()
            }
        }

        return ResponseEntity.status(response.status).body(response)
    }
}