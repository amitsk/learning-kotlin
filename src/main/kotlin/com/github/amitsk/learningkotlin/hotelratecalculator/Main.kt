package com.github.amitsk.learningkotlin.hotelratecalculator

import java.util.Currency
import java.util.Scanner

/**
 * MAin class for running the program. http://docs.oracle.com/javase/tutorial/essential/io/cl.html
 */
object Main {
    @JvmStatic fun main(args: Array<String>) {
        var zipCode: String?
        var month: Int
        val `in` = Scanner(System.`in`)

        do {
            // and stores into zipcode variable
            println("Enter a valid ZipCode ( Enter q to quit ):")
            zipCode = `in`.next()
            if (zipCode != null && zipCode.equals("q", ignoreCase = true)) {
                System.exit(0)
            }

            // Reads a integer from the console
            println("Enter a valid month number[1-12]:")
            month = `in`.nextInt()
            if (zipCode == null || month <= 0) {
                print("Calculation failed : Valid Zipcode and Month are required !!! ")
                System.exit(1)
            }

            val roomRateCalculator = RoomRateCalculator(
                    BaseRateForZipCodeService(Currency.getInstance("USD")),
                    DiscountRateService(),
                    TaxRateByZipCodeService())

            val totalRoomRate = roomRateCalculator.getTotalRoomRate(RoomRateCalculator.RoomRateInput(zipCode!!, month))
            println(String.format("The total room rate for %s and month %d is %f",
                    zipCode, month, totalRoomRate))

        } while (true)
    }
}
