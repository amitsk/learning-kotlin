package com.github.amitsk.learningkotlin.hotelratecalculator

import io.kotlintest.matchers.should
import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldThrow
import io.kotlintest.matchers.startWith
import io.kotlintest.properties.forAll
import io.kotlintest.properties.headers
import io.kotlintest.properties.row
import io.kotlintest.properties.table
import io.kotlintest.specs.FunSpec
import java.util.*

class BaseRateServiceSpec : FunSpec() {
    init {

        val currency = Currency.getInstance("USD")
        val baseRateService = BaseRateService(currency)

        test("Base Service should fail for null zip code") {
            shouldThrow<IllegalArgumentException> {
                baseRateService.getBaseRateForZipCode(null)
            }
        }

        test("Base Service should fail for a blank zip code") {
            shouldThrow<IllegalArgumentException> {
                baseRateService.getBaseRateForZipCode(" ")
                baseRateService.getBaseRateForZipCode("")
            }
        }

        test("Base Service should fail for unsupported zip code") {
            val zipCode = "12345"
            val exception = shouldThrow<IllegalArgumentException> {
                baseRateService.getBaseRateForZipCode(zipCode)
            }
            exception.message?.should(startWith("Zip Code $zipCode is not supported"))
        }

        test("Should Calculate Base rate for valid ZipCodes") {
            val myTable = table(
                    headers("zip", "result"),
                    row("97006", 100.0),
                    row("97007", 130.0),
                    row("97220", 140.0)
            )
            forAll(myTable) { zip, result ->
                baseRateService.getBaseRateForZipCode(zip) shouldBe Pair(result, currency)
            }
        }
    }
}
