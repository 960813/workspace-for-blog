package spring_31.chap05

/**
 * @Author Heli
 */

class UpgradeLevelsV2 {

    private val userDao = UserDao()

    fun main() {
        val user = User(User.Level.BASIC, 50L)

        if (user.isLevelUpgradable) {
            user.upgradeLevel()
        }
    }

    private val User.isLevelUpgradable: Boolean
        get() = when (this.level) {
            User.Level.BASIC -> this.loginCount >= 50L
            User.Level.SILVER -> this.recommendCount >= 30L
            User.Level.GOLD -> false
        }

    private fun User.upgradeLevel() {
        val nextLevel = this.level.next
            ?: throw IllegalStateException("[User.level=${this.level}] 은 업그레이드가 불가능합니다.")
        this.level = nextLevel
    }
}
