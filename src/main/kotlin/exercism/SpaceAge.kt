import java.math.BigDecimal

class SpaceAge(val seconds: Long) {
    companion object {
        fun baseYears(ageInSec: Long): Double = ageInSec / 31557600.0
        fun roundedYears(baseYears: Double, factor: Double): Double =
                BigDecimal(baseYears / factor)
                        .setScale(2, BigDecimal.ROUND_HALF_UP)
                        .toDouble()
    }

    val years = { factor: Double -> roundedYears(baseYears(seconds), factor) }

    fun onEarth() = years(1.0)
    fun onMars() = years(1.8808158)
    fun onVenus() = years(0.61519726)
    fun onMercury() = years(0.2408467)
    fun onJupiter() = years(11.862615)
    fun onSaturn() = years(29.447498)
    fun onUranus() = years(84.016846)
    fun onNeptune() = years(164.79132)

}