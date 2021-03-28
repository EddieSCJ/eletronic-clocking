package com.edcleidson.electronicclocking.domain

import com.edcleidson.electronicclocking.utils.helpers.BasicOperationsHelper
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty

class Password(password: String) {

    @field:NotEmpty(message = "The password might not be empty")
    @field:Length(min=8, message = "The password might have a minimum of 8 characters")
    val value: String

    init {
        value = generateBcryptPassword(password)
    }

    fun generateBcryptPassword(password: String): String = BasicOperationsHelper.bCryptPasswordEncoder.encode(password)
}
