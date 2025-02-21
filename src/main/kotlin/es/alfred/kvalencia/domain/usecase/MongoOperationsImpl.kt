package es.alfred.kvalencia.domain.usecase

import es.alfred.kvalencia.core.di.DataFactory
import es.alfred.kvalencia.data.mongo.entity.ServerAlive
import es.alfred.kvalencia.domain.model.BooleanResult
import es.alfred.kvalencia.domain.usecaseapi.MongoOperations

/**
 * @author Alfredo Sanz
 * @time 2025
 */
class MongoOperationsImpl : MongoOperations {

    private val mongoDAO = DataFactory.getMongoDAO()

    override suspend fun isAlive(): BooleanResult {
        var result: BooleanResult

        try {
            val resp: ServerAlive = this.mongoDAO.checkServerIsAlive()
            result = BooleanResult(resp.isalive)
        }
        catch (err: Exception) {
            println("Error in MongoOperations - isAlive -> $err")
            result = BooleanResult(false)
        }

        return result
    }
}