package spring_31.chap06

/**
 * @Author Heli
 */
class TransactionManager {
    fun begin() {}
    fun commit() {}
}

data class User(
    val name: String,
    val age: Long
)


fun createUser(
    name: String,
    age: Long
): User {
    val transactionManager = TransactionManager()
    transactionManager.begin()

    // ...
    val user = User(
        name = name,
        age = age
    )
    println(user)
    // ...

    transactionManager.commit()

    return user
}

fun main() {
    val user = createUser(
        name = "Heli",
        age = 99
    )
    println(user)
}
