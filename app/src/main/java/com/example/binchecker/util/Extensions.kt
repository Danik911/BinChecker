package com.example.binchecker.util

object Extensions {

    fun String?.formatWebAddress(): String{
        return "https://$this"
    }
    fun Boolean.parseResultToMessage(): String{
        return if (this) "Success" else "Fail"
    }
}