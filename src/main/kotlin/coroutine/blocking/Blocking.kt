package coroutine.blocking

import kotlinx.coroutines.*

/**
 * @author Heli
 */

private val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

fun main() {
    val blockingIOCall = blockingIOCall()
    println(blockingIOCall)
}

fun blockingIOCall(): List<Int> {
    val intContainer = (1..100).toList()
    return runBlocking(scope.coroutineContext) {
        intContainer
            .map {
                scope.async {
                    println(Thread.currentThread().name)
                    convert(intValue = it)
                }
            }.awaitAll()
            .map { it.intValue }
    }
}

fun convert(intValue: Int): Wrap = runBlocking {
    delay(100)
    Wrap(intValue)
}

data class Wrap(
    val intValue: Int
)
