import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Gigasecond(lclDateTime: LocalDateTime) {

    val date: LocalDateTime

    companion object {
        val gigaseconds: Duration = Duration.of(1000000000L, ChronoUnit.SECONDS)
    }

    constructor (lclDt: LocalDate) : this(lclDt.atStartOfDay())

    init {
        date = addGigaseconds(lclDateTime)
    }

    private fun addGigasecond(dt: LocalDateTime) =
            dt.plusSeconds(gigaseconds.toMillis() / 1000)

    fun addGigaseconds(dtTime: LocalDateTime): LocalDateTime =
            addGigasecond(dtTime)

}