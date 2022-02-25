package spring_31.chap01

/**
 * @Author Heli
 */
class Connection
class User

abstract class UserDao {
    fun findById(id: Long): User {
        val connection = getConnection()
        // ....
        return User(/*....*/)
    }

    protected abstract fun getConnection(): Connection
}

class KakaoUserDao : UserDao() {
    override fun getConnection(): Connection {
        // ...
        println("Kakao")
        return Connection(/*....*/)
    }
}

class NaverUserDao : UserDao() {
    override fun getConnection(): Connection {
        // ...
        println("Naver")
        return Connection(/*....*/)
    }
}
