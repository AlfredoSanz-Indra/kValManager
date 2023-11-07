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

    override suspend fun gitBranch() {
        val r: AntResult = this.antCommand.execAntGitCommand("git-branch")
        println("\"AntCommand - gitBranch  result=${r.result}")
    }

    override suspend fun gitPullList(microFs: List<String>) {
        microFs.forEach { it ->
            var r: AntResult = this.antCommand.execAntGitCommand("git-pull-$it")
            println("\"AntCommand - gitPullList - result=${r.result}")
        }
        println("\"executed Pull for microFrontales ($microFs)")
    }

    override suspend fun nodeRunMicroF(microF: String) {
        val r: AntResult = this.antCommand.execAntNodeCommands("run-$microF")
        println("\"AntCommand - nodeRun $microF - result=${r.result}")
    }

    override suspend fun nodeRunMicroFList(microFs: List<String>) {
        microFs.forEach { it ->
            var r: AntResult = this.antCommand.execAntNodeCommands("run-$it")
            println("\"AntCommand - nodeRun - result=${r.result}")
        }
        println("\"executed Node Run for microFrontales ($microFs)")
    }

    override suspend fun nodeCopyLib(copyLib: String, microFs: List<String>) {
        microFs.forEach { it ->
            val anttask: String = "copylib-$copyLib-$it"
            val r: AntResult = this.antCommand.execAntNodeCommands(anttask)
            println("\"AntCommand - $anttask - result=${r.result}")
        }
        println("\"Executed Node copyLib $copyLib for libraries ($microFs)")
    }

    override suspend fun coroutineTest(input: String) {
        val r: AntResult = this.antCommand.execTest(input)
        println("\"No command - test  result=${r.result}")
    }

    override suspend fun coroutineTestReturn(input: String): AntResult {
        val r: AntResult = this.antCommand.execTest(input)
        println("\"No command - test  result=${r.result}")

        return r
    }
}