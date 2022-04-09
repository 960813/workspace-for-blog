package spring_31.chap06.step01

/**
 * @Author Heli
 */
private class TransactionManager {
    fun begin() {}
    fun commit() {}
}

private data class User(
    val name: String,
    val age: Long
)


private fun createUser(
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
