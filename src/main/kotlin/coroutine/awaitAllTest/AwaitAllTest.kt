package coroutine.awaitAllTest

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll

/**
 * @Author Heli
 */
fun exceptionWhenParamIsFour(number: Int): Int {
    if (number == 4) throw IllegalArgumentException("Test")
    return number
}

suspend fun main() {

//    normal()
    println(improve())
}

suspend fun normal() {

    val target = IntRange(1, 100).map { it }

    val awaitAll = target.map {
        GlobalScope.async {
            exceptionWhenParamIsFour(it)
        }
    }.awaitAll()

    println(awaitAll)
}

suspend fun improve(): List<Int> {

    val target = IntRange(1, 100).map { it }

    return target.map {
        GlobalScope.async {
            try {
                exceptionWhenParamIsFour(it)
            } catch (e: Exception) {
                null
            }
        }
    }.awaitAll().filterNotNull()
}
