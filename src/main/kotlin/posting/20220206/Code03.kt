package posting.`20220206`

/**
 * @Author Heli
 */
class SafetyButtonV2 {

    private var _isPressed: Boolean = false

    val isPressed: Boolean
        get() = _isPressed

    fun press(): Boolean {
        this._isPressed = true
        return this._isPressed
    }

    fun takeOff(): Boolean {
        this._isPressed = false
        return this._isPressed
    }
}

fun main() {
    val button = SafetyButtonV2()
    println(button.isPressed)

    button.press()
    println(button.isPressed)

    button.takeOff()
    println(button.isPressed)
}
