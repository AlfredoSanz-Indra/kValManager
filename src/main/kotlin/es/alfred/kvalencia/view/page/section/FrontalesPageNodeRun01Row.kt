package es.alfred.kvalencia.view.page.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import es.alfred.kvalencia.core.di.UseCaseFactory
import es.alfred.kvalencia.domain.usecaseapi.AntUseCase
import kotlinx.coroutines.*

/**
 * @author Alfredo Sanz
 * @time 2023
 */
class FrontalesPageNodeRun01Row {

    private val antUseCase: AntUseCase = UseCaseFactory.getAntUseCase()

    @Composable
    private fun getNodeButtonsColour(): ButtonColors {
        return ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF331099),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151)
        )
    }

    @Composable
    private fun getCopylibButtonsColour(): ButtonColors {
        return ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF361039),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151)
        )
    }

    @Composable
    fun getNodeRunRow01() {

        Row(
            Modifier.background(color = Color.White).width(800.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.width(20.dp))
            buttonRunLauncher()

            Spacer(Modifier.width(20.dp))
            nodeCopyLibStoreActionButton()

            Spacer(Modifier.width(20.dp))
            nodeCopyLibCoreActionButton()
        }
    }

    @Composable
    private fun buttonRunLauncher() {

        val coroutineScope = rememberCoroutineScope()

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = getNodeButtonsColour(),
            onClick = {
                coroutineScope.launch {
                    val defer = async(Dispatchers.IO) {
                        antUseCase.nodeRunMicroF("launcher")
                    }
                    defer.await()
                }
            }
        )
        {
            Text("node Run Launcher")
        }
    }

    @Composable
    private fun nodeCopyLibStoreActionButton() {

        val coroutineScope = rememberCoroutineScope()

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = getCopylibButtonsColour(),
            onClick = {
                coroutineScope.launch {
                    val defer = async(Dispatchers.IO) {
                        antUseCase.nodeCopyLib("store", mutableListOf("justcv-libraries","pltflibraries"))
                    }
                    defer.await()
                }
            }
        )
        {
            Text("Copylib Store")
        }
    }

    @Composable
    private fun nodeCopyLibCoreActionButton() {

        val coroutineScope = rememberCoroutineScope()

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = getCopylibButtonsColour(),
            onClick = {
                coroutineScope.launch {
                    val defer = async(Dispatchers.IO) {
                        antUseCase.nodeCopyLib("core", mutableListOf("justcv-libraries","pltflibraries"))
                    }
                    defer.await()
                }
            }
        )
        {
            Text("Copylib Core")
        }
    }
}