class Squares(val num: Int) {

    fun squareOfSum(): Int {
        val sum = (0..num).sum()
        return sum * sum
    }

    fun sumOfSquares() = (0..num).map { it * it }.sum()

    fun difference(): Int = squareOfSum() - sumOfSquares()
}