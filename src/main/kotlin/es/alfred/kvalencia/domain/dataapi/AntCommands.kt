package es.alfred.kvalencia.domain.dataapi

import es.alfred.kvalencia.domain.model.AntResult


/**
 * @author Alfredo Sanz
 * @time 2023
 */
interface AntCommands {

    fun execAntGitCheckout(antTaskName: String, destBranch: String, microID: String): AntResult

    fun execAntGitCommandSmart(antTaskName: String,  microID: String): AntResult

    fun execAntGitCommand(antTaskName: String): AntResult;

    fun execAntGitCommandSmartPush(destBranch: String): AntResult

    fun execAntNodeCommandsSmart(antTaskName: String,  microID: String): AntResult

    fun execAntNodeCommands(antTaskName: String): AntResult;

    suspend fun execTest(input: String): AntResult
}