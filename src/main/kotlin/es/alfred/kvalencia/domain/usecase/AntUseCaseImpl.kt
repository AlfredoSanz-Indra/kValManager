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

    override suspend fun gitCheckout(microFs: List<String>, destBranch: String) {
        microFs.forEach { it ->
            val r: AntResult = this.antCommand.execAntGitCheckout("git-checkout", destBranch, it)
            println("\"AntCommand - gitCheckout  result=${r.result}")
        }
    }

    override suspend fun gitPullAll() {
        val r: AntResult = this.antCommand.execAntGitCommand("git-pull-all")
        println("\"AntCommand - gitPullAll  result=${r.result}")
    }

    override suspend fun gitBranch() {
        val r: AntResult = this.antCommand.execAntGitCommand("git-branch")
        println("\"AntCommand - gitBranch  result=${r.result}")
    }

    override suspend fun gitPullList(microFs: List<String>) {
        microFs.forEach { it ->
            var r: AntResult = this.antCommand.execAntGitCommandSmart("git-pull-smart",  it)
            println("\"AntCommand - gitPullList - result=${r.result}")
        }
        println("\"executed Pull for microFrontales ($microFs)")
    }

    override suspend fun nodeRunMicroF(microF: String) {
        var r: AntResult = this.antCommand.execAntNodeCommandsSmart("run-smart", microF)
        println("\"AntCommand - nodeRun $microF - result=${r.result}")
    }

    override suspend fun nodeRunMicroFList(microFs: List<String>) {
        microFs.forEach { it ->
            var r: AntResult = this.antCommand.execAntNodeCommandsSmart("run-smart", it)
            println("\"AntCommand - nodeRun - result=${r.result}")
        }
        println("\"executed Node Run for microFrontales ($microFs)")
    }

    override suspend fun gitPushIntegration(destBranch: String) {
        var r: AntResult = this.antCommand.execAntGitCommandSmartPush(destBranch)
        println("\"AntCommand - git-push $destBranch - result=${r.result}")
    }

    override suspend fun nodeRunTestMicroF(microF: String) {
        var r: AntResult = this.antCommand.execAntNodeCommandsSmart("run-test", microF)
        println("\"AntCommand - nodeRun $microF - result=${r.result}")
    }

    override suspend fun nodeRunTestMicroFList(microFs: List<String>) {
        microFs.forEach { it ->
            var r: AntResult = this.antCommand.execAntNodeCommandsSmart("run-test", it)
            println("\"AntCommand - nodeRun - result=${r.result}")
        }
        println("\"executed Node Run for microFrontales ($microFs)")
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