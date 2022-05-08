package exposed.sample.exception

import org.h2.jdbc.JdbcSQLException
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * @Author Heli
 */
object Users : Table() {
    val id = varchar("id", 10)
    val name = varchar("name", length = 50).uniqueIndex("UK_User_NAME")

    override val primaryKey = PrimaryKey(id, name = "PK_User_ID")
}

fun main() {
    Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver", user = "root", password = "")

    transaction {
        addLogger(StdOutSqlLogger)
        SchemaUtils.create(Users)
        Users.insert {
            it[id] = "andrey"
            it[name] = "Andrey"
        }
        try {
            Users.insert {
                it[id] = "Heli"
                it[name] = "Andrey"
            }
        } catch (e: ExposedSQLException) {
            if (e.cause is JdbcSQLException) {
                println("JdbcSQLException 입니다")
                if (e.errorCode == 23505) {
                    println("23505 에러코드입니다")
                }
            }
        }
        SchemaUtils.drop(Users)
    }
}
