data class CalculatorConfig(
    val name: String,
    val status: Boolean = true
)

class Calculator {
    fun isAvailable(config: CalculatorConfig): Boolean {
        return config.status
    }
}
