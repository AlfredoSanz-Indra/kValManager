package es.alfred.kvalencia.domain.usecaseapi

import es.alfred.kvalencia.domain.model.BooleanResult

/**
 * @author Alfredo Sanz
 * @time 2025
 */
interface MongoOperations {

    suspend fun isAlive(): BooleanResult
}