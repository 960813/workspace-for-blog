package companion

/**
 * @author Heli
 */
data class Description(
    val description: String
)

class ByLazy {
    companion object {
        private val description by lazy { Description("ByLazy") }
    }

    fun call() {
        println(description.description)
    }
}

class Concrete {
    companion object {
        private val description = Description("ByLazy")
    }

    fun call() {
        println(description.description)
    }
}
