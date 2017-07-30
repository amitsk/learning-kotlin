package com.github.amitsk.learningkotlin.hotelratecalculator


import spark.Spark.get
import java.lang.Integer.parseInt
import java.time.Month
import java.util.*


object RoomRateCalculatorResource {

    private val roomRateCalculator = RoomRateCalculator(
            BaseRateService(Currency.getInstance("USD")).getBaseRateForZipCode,
            DiscountRateService.getDiscountRateForMonth,
            TaxRateService.getTaxPercentForZipCode)

    @JvmStatic fun main(args: Array<String>) {
        get("/roomrate/:zipcode/:month") { request, response ->
            val zipCode = request.params(":zipcode")
            val month = request.params(":month")

            if (zipCode == null || zipCode.isEmpty() || month == null || month.isEmpty()) {
                response.status(400)
                return@get response
            } else {
                return@get roomRateCalculator.getTotalRoomRate(RoomRateInput(zipCode,
                        Month.of(parseInt(month))))
            }

        }
    }
}
