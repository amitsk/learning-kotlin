package com.github.amitsk.learningkotlin.hotelratecalculator

import java.util.Currency

/**
 * Get the base room rate for a zip code.
 * Only supports zip codes - 97006, 97007, 97220

 */
class BaseRateForZipCodeService(currency: Currency) {

    private val currency:Currency

    init {
        this.currency = currency
    }

    fun getBaseRateForZipCode(zipCode: String?): Double {
        var rate = 0.0
        if (zipCode == null) {
            throw IllegalArgumentException("Null Zip Code is not supported")
        }
        when (zipCode) {
            "97006" -> rate = 100.0
            "97007" -> rate = 130.0
            "97220" -> rate = 140.0
            else -> throw IllegalArgumentException(String.format("Zip Code %s is not supported", zipCode))
        }
        return rate
    }

}


