package lambda

/**
 * @Author Heli
 */

typealias Decorator = (() -> ProcessResponse) -> ProcessResponse

object AuditDecoratorGenerator {

    fun generate(): Decorator {
        return { supplier ->
            println("Request Start")
            val response = supplier()
            println("response in Decorator: $response")
            println("Request Complete")
            response
        }
    }
}

data class ProcessResponse(
    val status: Long = 500
)

class PayRequestProcessor(
    private val decorator: Decorator
) {

    fun process(): ProcessResponse {
        return decorator {
            ProcessResponse(
                status = 200
            )
        }
    }
}

fun main() {
    val processor = PayRequestProcessor(
        decorator = AuditDecoratorGenerator.generate()
    )

    val response = processor.process()

    println("response in main(): $response")
}
