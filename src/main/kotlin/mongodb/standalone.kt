package mongodb

import com.mongodb.MongoClientSettings
import com.mongodb.MongoCredential

import com.mongodb.client.MongoClients
import com.mongodb.connection.ConnectionPoolSettings
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit


/**
 * @author Heli
 * Created on 2022. 09. 01
 */
fun main() {
    val logger = LoggerFactory.getLogger("test")
    logger.info("TEST")
    val client = MongoClients.create(
        MongoClientSettings.builder()
            .credential(MongoCredential.createCredential("root", "admin", "1234".toCharArray()))
            .applyToConnectionPoolSettings { builder: ConnectionPoolSettings.Builder ->
                builder.minSize(5)
                builder.maxConnectionIdleTime(10000,TimeUnit.MILLISECONDS)
            }
            .build())

    Thread.sleep(Long.MAX_VALUE)
}
