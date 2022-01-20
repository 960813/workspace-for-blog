package lambda

import java.time.LocalDateTime
import java.time.LocalTime

/**
 * @Author Heli
 */

abstract class AbstractRunner {

    lateinit var startDateTime: LocalDateTime
    lateinit var endDateTime: LocalDateTime
}

class FirstRunner : AbstractRunner()
class SecondRunner : AbstractRunner()

class RunnerGenerator<T : AbstractRunner>(
    private val supplier: () -> T
) {

    fun generate(): T {
        val yesterday = LocalDateTime.now().minusDays(1).toLocalDate()
        return supplier.invoke().apply {
            this.startDateTime = LocalDateTime.of(yesterday, LocalTime.MIDNIGHT)
            this.endDateTime = LocalDateTime.of(yesterday, LocalTime.MAX)
        }
    }
}

fun main() {
    val generator = RunnerGenerator(::SecondRunner)
    val runner = generator.generate()
}
