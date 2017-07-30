package com.github.amitsk.learningkotlin.hotelratecalculator

import java.util.Currency

/**
 * Get the base room rate for a zip code.
 * Only supports zip codes - 97006, 97007, 97220
 */
object TaxRateService {

    val getTaxPercentForZipCode: (String?) -> Rate = { zipCode ->
        require(!zipCode.isNullOrEmpty())

        when (zipCode) {
            "97006" -> 11.0
            "97007" -> 12.6
            "97229" -> 11.3
            else -> throw IllegalArgumentException(String.format("Zip Code %s is not supported", zipCode))
        }
    }

}
