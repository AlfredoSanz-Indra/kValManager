package es.alfred.kvalencia.core.di

import es.alfred.kvalencia.data.ant.AntCommandsImpl
import es.alfred.kvalencia.data.mongo.MongoDAOImpl
import es.alfred.kvalencia.domain.dataapi.AntCommands
import es.alfred.kvalencia.domain.dataapi.MongoDAO
import es.alfred.kvalencia.domain.usecase.AntUseCaseImpl
import es.alfred.kvalencia.domain.usecaseapi.AntUseCase

object DataFactory {

    private lateinit var antCommand: AntCommands
    private lateinit var mongoDAO: MongoDAO

    fun getAntCommands(): AntCommands {
        if (!this::antCommand.isInitialized) {
            this.antCommand = AntCommandsImpl()
        }
        return this.antCommand
    }

    fun getMongoDAO(): MongoDAO {
        if (!this::mongoDAO.isInitialized) {
            this.mongoDAO = MongoDAOImpl()
        }
        return this.mongoDAO
    }
}