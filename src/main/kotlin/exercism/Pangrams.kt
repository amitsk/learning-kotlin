object Pangrams {
    fun isPangram(str: String): Boolean {
        val res = when {
            str?.length < 26 -> false
            str?.toLowerCase().groupBy { it }
                    .keys.filter { it <= 'z' && it >= 'a' }
                    .count() == 26 -> true
            else -> false
        }
        return res
    }
}