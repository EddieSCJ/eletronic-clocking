package com.edcleidson.electronicclocking.domain.enums

enum class EntryType(private val code: Int, private val description: String) {
    DAY_STARTING(1, "Day Start"),
    LUNCH_STARTING(2,"Lunch Start"),
    LUNCH_ENDING(3, "Lunch End"),
    PAUSE_STARTING(4, "Pause Start"),
    PAUSE_ENDING(5, "Pause End"),
    DAY_ENDING(6, "Day End");

    fun getCode(): Int = this.code
    fun getDescription(): String = this.description

    companion object {
        fun toEnum(code: Int): EntryType {
            if (code.equals(null)) throw IllegalAccessException("The code might not be null")

            val response: EntryType? = EntryType.values().find { entryType -> code == entryType.getCode() }
            if (response != null) return response

            throw IllegalAccessException("Invalid Entry Type Code: $code")
        }
    }
}