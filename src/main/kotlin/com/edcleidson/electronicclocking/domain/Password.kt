package com.edcleidson.electronicclocking.domain

import com.edcleidson.electronicclocking.utils.helpers.BasicOperationsHelper

class Password(password: String) {
    val value: String

    init {
        value = generateBcryptPassword(password)
    }

    fun generateBcryptPassword(password: String): String = BasicOperationsHelper.bCryptPasswordEncoder.encode(password)
}
