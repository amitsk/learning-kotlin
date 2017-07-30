package com.github.amitsk.learningkotlin.hotelratecalculator

import java.time.Month

typealias ZipCode = String
typealias RoomRate = Double
typealias Percentage = Double

data class RoomRateResult(val zip: ZipCode, val month: Month, val rate: RoomRate)
data class RoomRateInput(val zipCode: ZipCode, val month: Month)