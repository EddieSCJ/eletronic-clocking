package com.edcleidson.electronicclocking.domain

import com.edcleidson.electronicclocking.utils.helpers.BasicOperationsHelper
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PasswordTest {

    private val PASSWORD_STRING = "123456"

    @Test
    fun shouldGenerateAHashPasswordEqualsToProvidedPassword() {
        val password = Password(PASSWORD_STRING)
        assertTrue(BasicOperationsHelper.bCryptPasswordEncoder.matches(PASSWORD_STRING, password.value))
    }

}