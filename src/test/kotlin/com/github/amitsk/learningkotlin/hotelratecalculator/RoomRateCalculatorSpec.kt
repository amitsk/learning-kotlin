package com.github.amitsk.learningkotlin.hotelratecalculator

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.FunSpec
import java.time.Month
import java.util.*

class RoomRateCalculatorSpec : FunSpec() {
    init {
        test("RoomRate calculator should return correct room rate") {
            val roomRateCalculator = RoomRateCalculator(
                    { _ -> Pair(100.0, Currency.getInstance("USD")) },
                    { _ -> 10.0 },
                    { _ -> 10.0 })

            roomRateCalculator.getTotalRoomRate(RoomRateInput("100", Month.JANUARY)) shouldBe
                    RoomRateResult(zip = "100", month = Month.JANUARY, rate = 100 * (1 + 0.1 + 0.1))
        }
    }
}