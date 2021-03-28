package com.edcleidson.electronicclocking.utils.helpers

import com.edcleidson.electronicclocking.domain.enums.Role
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class BasicOperationsHelper {
    companion object {
        val bCryptPasswordEncoder = BCryptPasswordEncoder()
        const val API = "api"
    }
}