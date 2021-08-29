import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class DiExampleTest {
    private val calculator = Calculator()

    @Test
    fun `config 의 status 가 false 이면 false 를 리턴한다`() {
        // then
        val config = CalculatorConfig("First Calculator", false)

        // when
        val actual = calculator.isAvailable(config)

        // then
        expectThat(actual) isEqualTo false
    }

    @Test
    fun `config 의 status 가 true 이면 true 를 리턴한다`() {
        //then
        val config = CalculatorConfig("First Calculator", true)

        // when
        val actual = calculator.isAvailable(config)

        // then
        expectThat(actual) isEqualTo true
    }
}
