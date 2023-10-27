package es.alfred.kvalencia.domain.usecase

import es.alfred.kvalencia.core.di.DataFactory
import es.alfred.kvalencia.domain.dataapi.AntCommands
import es.alfred.kvalencia.domain.model.AntResult
import es.alfred.kvalencia.domain.usecaseapi.AntUseCase

/**
 * @author Alfredo Sanz
 * @time 2023
 */
class AntUseCaseImpl: AntUseCase {

    private val antCommand: AntCommands = DataFactory.getAntCommands()

    override suspend fun gitPullAll() {
        val r: AntResult = this.antCommand.execAntGitCommand("git-pull-all")
        println("\"AntCommand - gitPullAll  result=${r.result}")
    }

    override suspend fun gitPullLibraries() {
        val r: AntResult = this.antCommand.execAntGitCommand("git-pull-libraries")
        println("\"AntCommand - gitPullLibraries  result=${r.result}")
    }

    override suspend fun coroutineTest(input: String) {
        val r: AntResult = this.antCommand.execTest(input)
        println("\"No command - test  result=${r.result}")
    }
}