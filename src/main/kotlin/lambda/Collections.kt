package lambda

/**
 * @Author Heli
 */
class Book(val title: String, val authors: List<String>)

val books = listOf(
    Book("Kotlin in Action", listOf("A", "B", "C", "D")),
    Book("KakaoPay S01E01", listOf("D"))
)

fun main() {

    println(books.map { it.authors }.flatten())
    println(books.flatMap { it.authors }.toSet())
}
