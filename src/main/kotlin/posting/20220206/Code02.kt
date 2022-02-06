package posting.`20220206`

/**
 * @Author Heli
 */
class SafetyButton(
    val isPressed: Boolean = false
) {

    fun press(): SafetyButton {
        return SafetyButton(true)
    }

    fun takeOff(): SafetyButton {
        return SafetyButton(false)
    }
}

fun main() {
    val button = SafetyButton()
    val pressedButton = button.press()
    val takeOffButton = pressedButton.takeOff()

    println(button.isPressed)
    println(pressedButton.isPressed)
    println(takeOffButton.isPressed)
}
