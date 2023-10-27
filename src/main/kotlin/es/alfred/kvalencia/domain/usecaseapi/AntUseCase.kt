package es.alfred.kvalencia.domain.usecaseapi

/**
 * @author Alfredo Sanz
 * @time 2023
 */
interface AntUseCase {

    suspend fun gitPullAll();

    suspend fun gitPullLibraries();

    suspend fun coroutineTest(input: String);
}