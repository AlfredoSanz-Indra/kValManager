package es.alfred.kvalencia.core.di

import es.alfred.kvalencia.domain.usecase.AntUseCaseImpl
import es.alfred.kvalencia.domain.usecase.MongoOperationsImpl
import es.alfred.kvalencia.domain.usecaseapi.AntUseCase
import es.alfred.kvalencia.domain.usecaseapi.MongoOperations

/**
 * @author Alfredo Sanz
 * @time 2023
 */
object UseCaseFactory {

    private lateinit var antUseCase: AntUseCase
    private lateinit var mongoOperations: MongoOperations

    fun getAntUseCase(): AntUseCase {
        if (!this::antUseCase.isInitialized) {
            this.antUseCase = AntUseCaseImpl()
        }
        return this.antUseCase
    }

    fun getMongoOperations(): MongoOperations {
        if (!this::mongoOperations.isInitialized) {
            this.mongoOperations = MongoOperationsImpl()
        }
        return this.mongoOperations
    }
}