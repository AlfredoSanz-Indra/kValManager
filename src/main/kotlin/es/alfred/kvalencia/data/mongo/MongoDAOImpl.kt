package es.alfred.kvalencia.data.mongo

import com.mongodb.MongoException
import es.alfred.kvalencia.core.db.mongo.MongoConn
import es.alfred.kvalencia.data.mongo.entity.ServerAlive
import es.alfred.kvalencia.domain.dataapi.MongoDAO
import org.bson.BsonInt64
import org.bson.Document

/**
 * @author Alfredo Sanz
 * @time 2025
 */
class MongoDAOImpl : MongoDAO {

    override suspend fun checkServerIsAlive(): ServerAlive {
        var result: ServerAlive

        val mongoClient = MongoConn.getClient()
        val database = mongoClient.getDatabase("kexterioresDB")
        try {
            val command = Document("ping", BsonInt64(1))
            database.runCommand(command)
            result = ServerAlive(true)
        }
        catch (me: MongoException) {
            println("Error trying to connect Mongo -> $me")
            result = ServerAlive(false)
        }

        return result
    }
}