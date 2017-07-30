object Hamming {
    fun compute( one: String, two: String) : Int  {
        if(one.length != two.length) {
            throw IllegalArgumentException("leftStrand and rightStrand must be of equal length.")
        }
        return one.zip(two).filter { it.first != it.second }.count()
    }

}