class Triangle(val x: Double, val y: Double, val z: Double) {
    constructor(x1: Int, y1: Int, z1: Int) :
            this(x1.toDouble(), y1.toDouble(), z1.toDouble())

    init {
        require(x > 0.0 && y > 0.0 && z > 0.0)
        require(x + y >= z && y + z > x && x + z > y)
    }

    val isEquilateral: Boolean
        get() = x == y && y == z

    val isIsosceles: Boolean
        get() = (x == y || y == z || x == z)

    val isScalene: Boolean
        get() = x != y && y != z && x != z

}