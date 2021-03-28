package com.edcleidson.electronicclocking.domain.enums.constants

enum class HttpResponses(private val code: Int, private val description: String) {
    OK(200, "OK"),
    ALREADY_EXISTS(406, "The data you are trying insert in our database already exists"),
    BAD_REQUEST(400, "The provided body or parameters are invalid"),
    UNABLE_PERFORM_DELETE(500, "We are unable to perform your deleting, please contact the team"),
    NOT_FOUND(404, "Unfortunately we didn't found a result to your request");

    fun getCode(): Int = this.code
    fun getDescription(): String = this.description


}