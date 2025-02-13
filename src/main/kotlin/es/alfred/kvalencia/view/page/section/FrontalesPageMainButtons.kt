package es.alfred.kvalencia.view.page.section

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import es.alfred.kvalencia.core.Constants

/**
 * @author Alfredo Sanz
 * @time 2023
 */
class FrontalesPageMainButtons {

    @Composable
    private fun getBigButtonsColour(): ButtonColors {
        return ButtonDefaults.outlinedButtonColors(
            containerColor = Color(0xFF336699),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151),
            disabledContainerColor = Color(0XFFe83151)
            /*backgroundColor = Color(0xFF41521F),
            contentColor = Color(0xFFEFF2EF),
            disabledContentColor = Color(0xFF41521F)*/
        )
    }

    @Composable
    private fun getSmallButtonsColour(): ButtonColors {
        return ButtonDefaults.outlinedButtonColors(
            containerColor = Color(0xFF336699),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151),
            disabledContainerColor = Color(0XFFe83151)
            /*backgroundColor = Color(0xFF41121F),
            contentColor = Color(0xFFEFF2EF),
            disabledContentColor = Color(0xFF41121F)*/
        )
    }

    @Composable
    fun createPage(onViewChange: (Byte) -> Unit) {

        var v: Byte by remember { mutableStateOf(0) }
        var v2: Byte by remember { mutableStateOf(v) }

        if(v != v2) {
            onViewChange(v)
            v2 = v
        }

        Spacer(Modifier.width(40.dp))
        buttonGitCommands(onViewChoose = {v = it})

        Spacer(Modifier.width(10.dp))
        buttonNodeCommands(onViewChoose = {v = it})

        Spacer(Modifier.width(10.dp))
        buttonTest(onViewChoose = {v = it})
    }

    @Composable
    private fun buttonGitCommands(onViewChoose: (Byte) -> Unit) {
        OutlinedButton(modifier = Modifier.width(200.dp)
            .height(70.dp),
            colors = getBigButtonsColour(),
            onClick = {
                onViewChoose(Constants.theviewGit)
            }
        ) {
            Text("Git Commands")
        }
    }

    @Composable
    private fun buttonNodeCommands(onViewChoose: (Byte) -> Unit) {
        OutlinedButton(modifier = Modifier.width(200.dp)
            .height(70.dp),
            colors = getBigButtonsColour(),
            onClick = {
                onViewChoose(Constants.theviewNode)
            }
        ) {
            Text("Node Commands")
        }
    }

    @Composable
    private fun buttonTest(onViewChoose: (Byte) -> Unit) {
        OutlinedButton(modifier = Modifier.width(100.dp).height(50.dp),
            colors = getSmallButtonsColour(),
            onClick = {
                onViewChoose(Constants.theviewTests)
            }
        ) {
            Text("Tests")
        }
    }
}