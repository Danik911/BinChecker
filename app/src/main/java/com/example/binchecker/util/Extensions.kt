package com.example.binchecker.util

import android.content.Intent
import com.example.binchecker.domain.model.Bank

object Extensions {

    fun String?.formatWebAddress(): String {
        return "https://$this"
    }

    fun String?.formatPhoneNumber(): String {
        return "tel:$this"
    }

    fun Boolean.parseResultToMessage(): String {
        return if (this) "Success" else "Fail"
    }

}