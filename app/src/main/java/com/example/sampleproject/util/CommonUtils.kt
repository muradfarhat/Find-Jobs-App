package com.example.sampleproject.util

object CommonUtils {

    fun isValidEmailFormat(email: String): Boolean {
        val emailFormat = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        return email.matches(emailFormat.toRegex())
    }
}