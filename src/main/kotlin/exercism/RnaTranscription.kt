/*
* `G` -> `C`
* `C` -> `G`
* `T` -> `A`
* `A` -> `U`
 */
fun transcribeToRna(dna: String): String {
    val aMap = mapOf('G' to 'C', 'C' to 'G', 'T' to 'A', 'A' to 'U')
    return dna.map { aMap[it] }.joinToString("")
}
