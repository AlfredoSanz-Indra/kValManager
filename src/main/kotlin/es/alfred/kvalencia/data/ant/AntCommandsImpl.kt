package es.alfred.kvalencia.data.ant

import androidx.compose.runtime.rememberCoroutineScope
import es.alfred.kvalencia.domain.dataapi.AntCommands
import es.alfred.kvalencia.domain.model.AntResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.CompletableFuture
import kotlin.coroutines.CoroutineContext


/**
 * @author Alfredo Sanz
 * @time 2023
 */
class AntCommandsImpl : AntCommands {

    override fun execAntGitCommand(antTaskName: String): AntResult {

        ProcessBuilder("cmd /C start ant $antTaskName".split(" "))
            .redirectOutput(ProcessBuilder.Redirect.INHERIT)
            .start()
            .waitFor()


        return AntResult("Ant Task Git launched")

        /* Alternative way
        val command: List<String> = "cmd /c start ant $antTaskName".split(" ")
        val arCommand = Array(command.size) { command[it] }
        println("doAction: Executing ant command ->  $command")
        Runtime.getRuntime().exec(arCommand)
        return AntResult("Ant Task launched")
        */
    }

    override fun execAntNodeCommands(antTaskName: String): AntResult {

        ProcessBuilder("cmd /C ant $antTaskName".split(" "))
            .redirectOutput(ProcessBuilder.Redirect.INHERIT)
            .start()
            .waitFor()


        return AntResult("Ant Task Node launched")
    }

    override suspend fun execTest(input: String): AntResult {

            for (i in 1..1000000) {
                println("$input : $i")

            }
        return AntResult("Test finished")
    }
}