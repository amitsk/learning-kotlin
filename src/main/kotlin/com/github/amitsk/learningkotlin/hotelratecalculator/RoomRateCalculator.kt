package com.github.amitsk.learningkotlin.hotelratecalculator

/**
 * Get the room rate for a zip code and the month
 */
class RoomRateCalculator(private val baseRateSvc: BaseRateForZipCodeService,
                         private val discountSvc: DiscountRateService,
                         private val taxSvc: TaxRateByZipCodeService) {

    fun getTotalRoomRate(roomRateInput: RoomRateInput): Double {
        val taxRate = taxSvc.getTaxPercentForZipCode(roomRateInput.zipCode)
        val baseRate = baseRateSvc.getBaseRateForZipCode(roomRateInput.zipCode)
        val discountRateForMonth = discountSvc.getDiscountRateForMonth(roomRateInput.month)

        return baseRate * (1 + discountRateForMonth) + baseRate * (taxRate / 100)
    }

    data class RoomRateInput(val zipCode: String, val month: Int)
}
