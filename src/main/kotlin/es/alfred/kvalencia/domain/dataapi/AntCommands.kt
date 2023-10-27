package es.alfred.kvalencia.domain.dataapi

import es.alfred.kvalencia.domain.model.AntResult


/**
 * @author Alfredo Sanz
 * @time 2023
 */
interface AntCommands {

    fun execAntGitCommand(antTaskName: String): AntResult;

    suspend fun execTest(input: String): AntResult
}