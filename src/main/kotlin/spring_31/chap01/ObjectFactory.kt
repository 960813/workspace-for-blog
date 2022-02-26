package spring_31.chap01

/**
 * @Author Heli
 */

// ConnectionMaker
interface ConnectionMaker {
    fun getConnection()
}

class KakaoConnectionMaker : ConnectionMaker {
    override fun getConnection() {
    }
}

// Dao using on Client
interface Dao {
    fun run()
}

class AccountDao(
    private val connectionMaker: ConnectionMaker
) : Dao {

    override fun run() {
        /*..*/ connectionMaker.getConnection()
        println("accountDao run()")
    }
}

class RecommendDao(
    private val connectionMaker: ConnectionMaker
) : Dao {

    override fun run() {
        /*..*/ connectionMaker.getConnection()
        println("userDao run()")
    }
}

// Factory
object DaoFactory {

    fun accountDao() = AccountDao(connectionMaker = connectionMaker())

    fun recommendDao() = RecommendDao(connectionMaker = connectionMaker())

    private fun connectionMaker(): ConnectionMaker {
        return KakaoConnectionMaker()
    }
}

// Client
class DaoClient private constructor(
    private val dao: Dao
) {

    fun runDao() {
        dao.run()
    }

    companion object {
        operator fun invoke(dao: Dao): DaoClient {
            println("invoke DaoClient")
            return DaoClient(dao = dao)
        }
    }
}

fun main() {
    val accountDao = DaoFactory.accountDao()
    val daoClientWithAccountDao = DaoClient(dao = accountDao)
    daoClientWithAccountDao.runDao()

    println("========")

    val recommendDao = DaoFactory.recommendDao()
    val daoClientWithRecommendDao = DaoClient(dao = recommendDao)
    daoClientWithRecommendDao.runDao()
}
