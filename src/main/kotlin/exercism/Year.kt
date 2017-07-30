class Year(val year: Int) {
    val isLeap: Boolean
        get() = isLeapYear()

    fun isLeapYear(): Boolean =
            when {
                year % 400 == 0 -> true
                year % 4 == 0 && year % 100 != 0 -> true
                else -> false
            }

}