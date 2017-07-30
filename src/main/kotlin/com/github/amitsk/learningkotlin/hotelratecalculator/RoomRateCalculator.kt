package com.github.amitsk.learningkotlin.hotelratecalculator

import java.time.Month
import java.util.*

/**
 * Get the room rate for a zip code and the month
 */
class RoomRateCalculator(val baseRateSvc: (ZipCode) -> Pair<RoomRate, Currency>,
                         val discountSvc: (Month) -> Rate,
                         val taxSvc: (ZipCode) -> Rate) {

    fun getTotalRoomRate(roomRateInput: RoomRateInput): RoomRateResult {
        val taxRate = taxSvc(roomRateInput.zipCode)
        val baseRate = baseRateSvc(roomRateInput.zipCode)
        val discountRateForMonth = discountSvc(roomRateInput.month)

        val rate = baseRate.first * (1 + discountRateForMonth) +
                baseRate.first * (taxRate / 100)
        return RoomRateResult(roomRateInput.zipCode,
                roomRateInput.month, rate)
    }

}
