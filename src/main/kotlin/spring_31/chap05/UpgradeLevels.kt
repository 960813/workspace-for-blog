package spring_31.chap05

/**
 * @Author Heli
 */
class UserDao {
    fun update(user: User) {

    }
}

data class User(var level: Level = Level.BASIC, val loginCount: Long = 0L, val recommendCount: Long = 0L) {
    enum class Level(val next: Level?) {
        GOLD(null), SILVER(GOLD), BASIC(SILVER)
    }
}

fun main() {
    val userDao = UserDao()

    val user = User()

    var changed = false
    if (user.level == User.Level.BASIC && user.loginCount >= 50L) {
        user.level = User.Level.SILVER
        changed = true
    }
    if (changed) {
        userDao.update(user)
    }
}
