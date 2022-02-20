package sequence

/**
 * @Author Heli
 */
val primes: Sequence<Int> = sequence {
    var numbers = generateSequence(2) { it + 1 }

    while (true) {
        val prime = numbers.first()
        yield(prime)
        numbers = numbers.drop(1)
            .filter {
                println("it: $it")
                it % prime != 0
            }
    }
}

fun main() {
    println(primes.take(5).toList())
}
