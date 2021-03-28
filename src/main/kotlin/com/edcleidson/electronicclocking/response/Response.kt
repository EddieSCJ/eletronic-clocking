package com.edcleidson.electronicclocking.response

data class Response<T>(
    val errors: MutableList<String> = arrayListOf(),
    var data: T? = null,
    var status: Int = 200
)