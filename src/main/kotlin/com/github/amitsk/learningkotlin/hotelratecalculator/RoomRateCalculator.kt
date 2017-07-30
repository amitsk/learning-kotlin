package com.github.amitsk.learningkotlin.hotelratecalculator

import java.time.Month
import java.util.*

/**
 * Get the room rate for a zip code and the month
 */
class RoomRateCalculator(private val baseRateSvc: (ZipCode) -> Pair<RoomRate, Currency>,
                         private val discountSvc: (Month) -> Percentage,
                         private val taxSvc: (ZipCode) -> Percentage) {

    fun getTotalRoomRate(roomRateInput: RoomRateInput): RoomRateResult {
        val taxPercent = taxSvc(roomRateInput.zipCode)
        val baseRate = baseRateSvc(roomRateInput.zipCode)
        val discountPercent = discountSvc(roomRateInput.month)

        val rate = baseRate.first * (1 + discountPercent/100) +
                baseRate.first * (taxPercent / 100)
        return RoomRateResult(roomRateInput.zipCode,
                roomRateInput.month, rate)
    }

}
