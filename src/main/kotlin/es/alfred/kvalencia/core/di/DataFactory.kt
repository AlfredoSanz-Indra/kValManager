package es.alfred.kvalencia.core.di

import es.alfred.kvalencia.data.ant.AntCommandsImpl
import es.alfred.kvalencia.domain.dataapi.AntCommands
import es.alfred.kvalencia.domain.usecase.AntUseCaseImpl
import es.alfred.kvalencia.domain.usecaseapi.AntUseCase

object DataFactory {

    private lateinit var antCommand: AntCommands

    fun getAntCommands(): AntCommands {
        if (!this::antCommand.isInitialized) {
            this.antCommand = AntCommandsImpl()
        }
        return this.antCommand
    }
}