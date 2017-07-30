package com.github.amitsk.learningkotlin.hotelratecalculator

import java.time.Month
import java.util.Currency
import java.util.Scanner

/**
 * MAin class for running the program. http://docs.oracle.com/javase/tutorial/essential/io/cl.html
 */
object Main {
    @JvmStatic fun main(args: Array<String>) {
        val `in` = Scanner(System.`in`)

        do {
            // and stores into zipcode variable
            println("Enter a valid ZipCode ( Enter q to quit ):")
            val zipCode = `in`.next()
            if (zipCode != null && zipCode.equals("q", ignoreCase = true)) {
                System.exit(0)
            }

            // Reads a integer from the console
            println("Enter a valid month number[1-12]:")
            val month = `in`.nextInt()
            if (zipCode == null || month <= 0) {
                print("Calculation failed : Valid Zipcode and Month are required !!! ")
                System.exit(1)
            }

            val roomRateCalculator = RoomRateCalculator(
                    BaseRateService(Currency.getInstance("USD")).getBaseRateForZipCode,
                    DiscountRateService.getDiscountRateForMonth,
                    TaxRateService.getTaxPercentForZipCode)

            val totalRoomRate = roomRateCalculator
                    .getTotalRoomRate(RoomRateInput(zipCode!!, Month.of(month)))
            println(String.format("The total room rate for %s and month %d is %s",
                    zipCode, month, totalRoomRate))

        } while (true)
    }
}
