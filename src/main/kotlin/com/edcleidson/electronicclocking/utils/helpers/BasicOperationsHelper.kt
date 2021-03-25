package com.edcleidson.electronicclocking.utils.helpers

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class BasicOperationsHelper {
    companion object {
        val bCryptPasswordEncoder = BCryptPasswordEncoder()
    }
}