object Luhn {
    val digitOrWs = { x: Char -> x.isDigit() || x.isWhitespace() }
    val numOps = { idx: Int, num: Int ->
        when {
            idx != 0 && idx % 2 != 0 -> {
                val dbl = num * 2
                if (dbl > 9) dbl - 9 else dbl
            }
            else -> num
        }
    }

    fun isValid(str: String): Boolean {
        if (str.trim().length <= 1 ||
                (str.filterNot { digitOrWs(it) }.length > 0)) return false

        val onlyNums: List<Int> = str.filter { it.isDigit() }.map { Character.getNumericValue(it) }
        val calcSum = onlyNums.reversed().mapIndexed { index, num -> numOps(index, num) }.sum()

        return calcSum % 10 == 0
    }
}