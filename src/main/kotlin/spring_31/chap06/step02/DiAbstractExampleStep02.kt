package spring_31.chap06.step02

/**
 * @Author Heli
 */
private class TransactionManager {
    fun begin() {
        println("===== tx begin =====")
    }

    fun commit() {
        println("===== tx commit =====")
    }
}

private data class User(
    val name: String,
    val age: Long
)

private interface UserService {
    fun createUser(name: String, age: Long): User
}

private class UserServiceImpl : UserService {
    override fun createUser(name: String, age: Long): User {
        val user = User(
            name = name,
            age = age
        )
        println(user)
        return user
    }
}

private class UserServiceTx(
    private val transactionManager: TransactionManager,
    private val userService: UserService
) : UserService {
    override fun createUser(name: String, age: Long): User {
        transactionManager.begin()
        val user = userService.createUser(name = name, age = age)
        transactionManager.commit()
        return user
    }
}

fun main() {
    val transactionManager = TransactionManager()
    val userServiceImpl: UserService = UserServiceImpl()
    val userServiceTx: UserService = UserServiceTx(
        transactionManager = transactionManager,
        userService = userServiceImpl
    )
    userServiceTx.createUser(
        name = "Heli",
        age = 99
    )
}
