package es.alfred.kvalencia.view

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
            backgroundColor = Color(0xFF336699),
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
            buttonRunDashboard()

            Spacer(Modifier.width(20.dp))
            buttonRunProcess()
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
    private fun buttonRunDashboard() {

        val coroutineScope = rememberCoroutineScope()

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = getNodeButtonsColour(),
            onClick = {
                coroutineScope.launch {
                    val defer = async(Dispatchers.IO) {
                        antUseCase.nodeRunMicroF("dashboard")
                    }
                    defer.await()
                }
            }
        )
        {
            Text("node Run Dashboard")
        }
    }

    @Composable
    fun buttonRunProcess() {

        val coroutineScope = rememberCoroutineScope()

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = getNodeButtonsColour(),
            onClick = {
                coroutineScope.launch {
                    val defer = async(Dispatchers.IO) {
                        antUseCase.nodeRunMicroF("process")
                    }
                    defer.await()
                }
            }
        )
        {
            Text("node Run Process")
        }
    }
}