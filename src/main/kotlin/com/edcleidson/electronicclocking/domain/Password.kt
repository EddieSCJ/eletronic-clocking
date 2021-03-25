package com.edcleidson.electronicclocking.domain

import com.edcleidson.electronicclocking.utils.helpers.BasicOperationsHelper

data class Password(val value: String) {
    fun generateBcryptPassword(): String = BasicOperationsHelper.bCryptPasswordEncoder.encode(value)
}
