package com.example.binchecker.util

import android.net.Uri
import com.example.binchecker.domain.model.Bank
import com.example.binchecker.domain.model.Country


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

    fun Country.parseBankLocationToString(bank: Bank?): String {
        return "geo:${this.latitude}.0000,${this.longitude}.0000?q=" + Uri.encode("${bank?.bankName}")

    }

}