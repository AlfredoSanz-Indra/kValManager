package es.alfred.kvalencia.domain.dataapi

import es.alfred.kvalencia.data.mongo.entity.ServerAlive

/**
 * @author Alfredo Sanz
 * @time 2025
 */
interface MongoDAO {

    suspend fun checkServerIsAlive(): ServerAlive
}