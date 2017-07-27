object Acronym {

    val reg = Regex("\\W")
    fun generate(str: String): String {
        return str.split(reg)
                .filter { !it.isEmpty() }
                .map { s ->
                    val pair = s.partition { it.isUpperCase() }
                    if (pair.second.isNullOrEmpty()) pair.first[0]
                    else if (pair.first.isEmpty()) pair.second[0].toUpperCase()
                    else pair.first
                }
                .joinToString("")
    }
}