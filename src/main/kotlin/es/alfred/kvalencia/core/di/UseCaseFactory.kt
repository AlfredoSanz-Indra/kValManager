package es.alfred.kvalencia.core.di

import es.alfred.kvalencia.domain.usecase.AntUseCaseImpl
import es.alfred.kvalencia.domain.usecaseapi.AntUseCase

/**
 * @author Alfredo Sanz
 * @time 2023
 */
object UseCaseFactory {

    private lateinit var antUseCase: AntUseCase

    fun getAntUseCase(): AntUseCase {
        if (!this::antUseCase.isInitialized) {
            this.antUseCase = AntUseCaseImpl()
        }
        return this.antUseCase
    }
}