package com.github.amitsk.learningkotlin.hotelratecalculator

class DiscountRateService {

    fun getDiscountRateForMonth(month: Int): Double {
        when {
            month <= 8 && month >= 6 -> return 0.5
            month == 12 || month == 11 -> return 0.2
            month == 3 -> return 0.3
            month == 10 || month == 2 || month == 1 -> return -0.3
            else -> return 0.0
        }
    }
}