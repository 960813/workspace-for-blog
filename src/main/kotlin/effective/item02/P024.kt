package effective.item02

/**
 * @Author Heli
 */

fun primeV1() {
    var numbers = (2..100).toList()
    val primes = mutableListOf<Int>()
    while (numbers.isNotEmpty()) {
        val prime = numbers.first()
        primes.add(prime)
        numbers = numbers.filter {
            it % prime != 0
        }
    }
    println(primes)
}

val primes: Sequence<Int> = sequence {
    var numbers = generateSequence(2) { it + 1 }

    while (true) {
        val prime = numbers.first()
        yield(prime)
        numbers = numbers.drop(1)
            .filter {
                it % prime != 0
            }
    }
}

val primesV2: Sequence<Int> = sequence {
    var numbers = generateSequence(2) { it + 1 }

    var prime:Int
    while (true) {
        prime = numbers.first()
        yield(prime)
        numbers = numbers.drop(1)
            .filter {
                it % prime != 0
            }
    }
}

fun main() {

//    primeV1()
//    println(primesV2.take(5).toList())
    println(primes.take(5).toList())
}
