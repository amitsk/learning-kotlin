object Raindrops {

    private val tuples = listOf(Pair(3, "Pling"), Pair(5, "Plang"), Pair(7, "Plong"))

    fun convert(num: Int): String {
        fun oneDrop(divisor: Int, prefix: String) = if (num % divisor == 0) prefix else ""

        return if (tuples.indexOfFirst { (first) -> num % first == 0 } > -1) {
            tuples.foldRight("", { (first, second), acc -> oneDrop(first, second) + acc })
        } else num.toString()
    }
}