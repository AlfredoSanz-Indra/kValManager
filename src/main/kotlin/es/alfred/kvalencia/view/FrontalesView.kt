package es.alfred.kvalencia.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import es.alfred.kvalencia.core.di.UseCaseFactory
import es.alfred.kvalencia.domain.usecaseapi.AntUseCase
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * @author Alfredo Sanz
 * @time 2023
 */
class FrontalesView : IView {

    private var theview: Byte = 0
    private val theviewGit: Byte = 1
    private val theviewNode: Byte = 2

    @Preview
    @Composable
    override fun createView() {

        var resulttext by rememberSaveable { mutableStateOf("Init View") }

        val antUseCase: AntUseCase = UseCaseFactory.getAntUseCase()

        MaterialTheme(colors = darkColors(background = Color.Black)) {
            Column {
                Row(
                    Modifier.background(color = Color(0xFFF8F7FF))
                    .height(130.dp)
                    .width(800.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    rowMainButtons(resulttext, onNameChange = { resulttext = it })
                }

                if(theviewGit == theview) {
                    Spacer(Modifier.height(20.dp))

                    Row(Modifier.background(color = Color.White)) {
                        rowGit(resulttext, onNameChange = { resulttext = it })
                    }
                }

                if(theviewNode == theview) {
                    Spacer(Modifier.height(20.dp))

                    Row(Modifier.background(color = Color.White)) {
                        rowNode(resulttext, onNameChange = { resulttext = it })
                    }
                }
            }
        }

    }

    @Composable
    private fun rowMainButtons(t: String, onNameChange: (String) -> Unit) {

        Spacer(Modifier.width(20.dp))

        val gitButtonsColor =  ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF41521F),
            contentColor = Color(0xFFEFF2EF),
            disabledContentColor = Color(0xFF41521F))

        Spacer(Modifier.width(20.dp))

        OutlinedButton( modifier = Modifier.width(200.dp)
            .height(70.dp),
            colors = gitButtonsColor,
            onClick =  {
                theview = theviewGit
                onNameChange("1.1")
            }
        ) {
            Text("Git Commands")
        }

        Spacer(Modifier.width(10.dp))

        OutlinedButton(modifier = Modifier.width(200.dp)
            .height(70.dp),
            colors = gitButtonsColor,
            onClick =  {
                theview = theviewNode
                onNameChange("1.2")
            }
        ) {
            Text("Node Commands")
        }
    }

    @Composable
    private fun rowGit(t: String, onNameChange: (String) -> Unit) {

        val antUseCase: AntUseCase = UseCaseFactory.getAntUseCase()

        val coroutineScope = rememberCoroutineScope()
        //val globalScope = kotlinx.coroutines.GlobalScope()

        val gitpullButtonsColor = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF336699),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151)
        )

        Spacer(Modifier.width(20.dp))

        OutlinedButton( modifier = Modifier.width(200.dp),
            colors = gitpullButtonsColor,
            onClick = {
                coroutineScope.launch {
                    onNameChange("2.1.1")
                    val async1 = async(Dispatchers.IO) {
                        antUseCase.gitPullAll()
                    }
                    onNameChange("2.1.2")
                    async1.await()
                }
            }
        )
        {
            Text("Git pull All")
        }

        Spacer(Modifier.width(20.dp))

        OutlinedButton( modifier = Modifier.width(200.dp),
            colors = gitpullButtonsColor,
            onClick = {
                GlobalScope.launch {
                    onNameChange("2.2.1")
                    val async1 = async(Dispatchers.IO) {
                        antUseCase.gitPullLibraries()
                    }
                    onNameChange("2.2.2")
                    async1.await()
                }
            }
        )
        {
            Text("Git pull Libraries")
        }
    }

    @Composable
    private fun rowNode(t: String, onNameChange: (String) -> Unit) {

        val antUseCase: AntUseCase = UseCaseFactory.getAntUseCase()

        val coroutineScope = rememberCoroutineScope()

        val gitpullButtonsColor = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF336699),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151)
        )

        Spacer(Modifier.width(20.dp))

        OutlinedButton( modifier = Modifier.width(200.dp),
            colors = gitpullButtonsColor,
            onClick = {
                coroutineScope.launch {
                    onNameChange("3.1.1")
                    val asy1 = async(Dispatchers.IO) {
                        antUseCase.coroutineTest("**")
                    }
                    onNameChange("3.1.2")
                    asy1.await()
                }
            }
        )
        {
            Text("Coroutine test")
        }
    }

}