package com.github.amitsk.learningkotlin.hotelratecalculator


import java.util.Currency

import java.lang.Integer.parseInt
import spark.Spark.*


object RoomRateCalculatorResource {

    private val roomRateCalculator = RoomRateCalculator(
            BaseRateForZipCodeService(Currency.getInstance("USD")),
            DiscountRateService(),
            TaxRateByZipCodeService())

    @JvmStatic fun main(args: Array<String>) {
        get("/roomrate/:zipcode/:month") { request, response ->
            val zipCode = request.params(":zipcode")
            val month = request.params(":month")

            if (zipCode == null || zipCode.isEmpty() || month == null || month.isEmpty()) {
                response.status(400)
                return@get response
            } else {
                return@get roomRateCalculator.getTotalRoomRate(RoomRateCalculator.RoomRateInput(zipCode, parseInt(month)))
            }

        }
    }
}
