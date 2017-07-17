package com.github.amitsk.learningkotlin.hotelratecalculator

import java.util.Currency

/**
 * Get the base room rate for a zip code.
 * Only supports zip codes - 97006, 97007, 97220
 */
class TaxRateByZipCodeService {


    fun getTaxPercentForZipCode(zipCode: String?): Double {

        var percent = 0.0
        if (zipCode == null) {
            throw IllegalArgumentException("Null Zip Code is not supported")
        }
        when (zipCode) {
            "97006" -> percent = 11.0
            "97007" -> percent = 12.6
            "97220" -> percent = 11.3
            else -> throw IllegalArgumentException(String.format("Zip Code %s is not supported", zipCode))
        }
        return percent
    }

}
