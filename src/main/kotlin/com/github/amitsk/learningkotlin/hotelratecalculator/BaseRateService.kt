package com.github.amitsk.learningkotlin.hotelratecalculator

import java.util.*

/**
 * Get the base room rate for a zip code.
 * Only supports zip codes - 97006, 97007, 97220

 */
class BaseRateService(val currency: Currency) {
    val getBaseRateForZipCode: (ZipCode?) -> Pair<Rate, Currency> = { zipCode ->
        require(!zipCode.isNullOrBlank())

        when (zipCode) {
            "97006" -> Pair(100.0, currency)
            "97007" -> Pair(130.0, currency)
            "97220" -> Pair(140.0, currency)
            else -> throw IllegalArgumentException(String.format("Zip Code %s is not supported", zipCode))
        }
    }

}


