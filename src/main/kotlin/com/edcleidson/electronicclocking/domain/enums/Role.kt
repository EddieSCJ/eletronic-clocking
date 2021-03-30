package com.edcleidson.electronicclocking.domain.enums

enum class Role(private val code: Int) {
    ROLE_ADMIN(1),
    ROLE_EMPLOYEE(2);

    fun getCode(): Int = this.code

    companion object {
        fun toEnum(code: Int): Role {
            if(code.equals(null)) throw IllegalAccessException("The code might not be null")

            val response: Role? = values().find { role -> code == role.getCode() }
            if(response != null) return response

            throw IllegalAccessException("Invalid Role Code: $code")
        }
    }


}