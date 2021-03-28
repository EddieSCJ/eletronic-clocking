package com.edcleidson.electronicclocking.domain.enums

enum class Role(private val code: Int, private val description: String) {
    ROLE_ADMIN(1, "Administrator"),
    ROLE_EMPLOYEE(2, "Employee");

    fun getCode(): Int = this.code
    fun getDescription(): String = this.description

    companion object {
        fun toEnum(code: Int): Role {
            if(code.equals(null)) throw IllegalAccessException("The code might not be null")

            val response: Role? = values().find { role -> code == role.getCode() }
            if(response != null) return response

            throw IllegalAccessException("Invalid Role Code: $code")
        }
    }


}