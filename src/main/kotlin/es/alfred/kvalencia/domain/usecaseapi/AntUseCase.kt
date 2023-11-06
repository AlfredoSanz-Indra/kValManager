package es.alfred.kvalencia.domain.usecaseapi

import es.alfred.kvalencia.domain.model.AntResult

/**
 * @author Alfredo Sanz
 * @time 2023
 */
interface AntUseCase {

    suspend fun gitPullAll();

    suspend fun gitPullLibraries();

    suspend fun gitBranch();

    suspend fun gitPullList(microFs: List<String>);

    suspend fun nodeRunMicroF(microF: String)

    suspend fun coroutineTest(input: String)

    suspend fun coroutineTestReturn(input: String): AntResult;
}