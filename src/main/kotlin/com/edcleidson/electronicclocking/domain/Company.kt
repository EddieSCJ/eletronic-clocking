package com.edcleidson.electronicclocking.domain

import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.br.CNPJ
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.NotEmpty

@Document
data class Company(
        @field:NotEmpty(message = "The social name might be not empty")
        @field:Length(min=3, max=200, message = "The company name might be between 3 and 200 characters")
        val socialName: String,

        @field:CNPJ(message = "You provided an invalid CNPJ")
        val cnpj: String,
        @Id  val id: String? = null,
)