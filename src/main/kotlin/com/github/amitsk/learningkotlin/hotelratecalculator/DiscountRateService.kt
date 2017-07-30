package com.github.amitsk.learningkotlin.hotelratecalculator

import java.time.Month
import java.time.Month.*

object DiscountRateService {

    val getDiscountRateForMonth: (Month) -> Percentage = { month ->
        when {
            month <= AUGUST && month >= JUNE -> 0.5
            month == DECEMBER || month == NOVEMBER -> 0.2
            month == MARCH -> 0.3
            month == OCTOBER || month == FEBRUARY || month == JANUARY -> -0.3
            else -> 0.0
        }
    }
}