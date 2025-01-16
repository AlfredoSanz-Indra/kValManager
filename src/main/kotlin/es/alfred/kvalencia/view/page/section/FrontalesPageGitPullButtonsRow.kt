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
class FrontalesPageGitPullButtonsRow {

    private val antUseCase: AntUseCase = UseCaseFactory.getAntUseCase()

    @Composable
    private fun getGitpullButtonsColour(): ButtonColors {
        val result = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF7BB661),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0xFF666699))

        return result
    }

    @Composable
    private fun getBranchButtonsColour(): ButtonColors {
        val result = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF849601),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0xFF666699))

        return result
    }

    @Composable
    fun gitpullsButtonRow() {
        Row(Modifier.background(color = Color.White).width(800.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.width(20.dp))
            gitBranchButton()

            Spacer(Modifier.width(20.dp))
            gitpullallButton()
        }
    }


    @Composable
    private fun gitBranchButton() {

        val coroutineScope = rememberCoroutineScope()

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = getBranchButtonsColour(),
            onClick = {
                coroutineScope.launch {
                    val defer = async(Dispatchers.IO) {
                        antUseCase.gitBranch()
                    }
                    defer.await()
                }
            }
        )
        {
            Text("Git Branch")
        }
    }

    @Composable
    private fun gitpullallButton() {

        val coroutineScope = rememberCoroutineScope()

        OutlinedButton( modifier = Modifier.width(200.dp),
            colors =  getGitpullButtonsColour(),
            onClick = {
                coroutineScope.launch {
                    val defer = async(Dispatchers.IO) {
                        antUseCase.gitPullAll()
                    }
                    defer.await()
                }
            }
        )
        {
            Text("Git pull All")
        }
    }
}