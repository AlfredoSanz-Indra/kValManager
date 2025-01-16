package es.alfred.kvalencia.view.page.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import es.alfred.kvalencia.core.di.UseCaseFactory
import es.alfred.kvalencia.domain.usecaseapi.AntUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * @author Alfredo Sanz
 * @time 2023
 */
class FrontalesPageNodeChipsButtonsRow {

    private val antUseCase: AntUseCase = UseCaseFactory.getAntUseCase()

    @Composable
    private fun getNodeRunActionButtonsColour(): ButtonColors {
        return ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF331099),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151)
        )
    }

    @Composable
    private fun getNodeTestActionButtonsColour(): ButtonColors {
        return ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF361039),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151)
        )
    }

    @Composable
    fun nodeChipsActionsRow(chipsSelected: MutableMap<String, Boolean>) {

        Row(
            Modifier.background(color = Color.White).width(800.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.width(20.dp))
            nodeRunActionButton(chipsSelected)
        }
    }

    @Composable
    private fun nodeRunActionButton(chipsSelected: MutableMap<String, Boolean>) {

        val coroutineScope = rememberCoroutineScope()

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = getNodeRunActionButtonsColour(),
            onClick = {
                coroutineScope.launch {
                    val defer = async(Dispatchers.IO) {
                        val chips = chipsSelected.filter { it -> it.value }
                        val chipsSelectedList = chips.keys.toList()
                        antUseCase.nodeRunMicroFList(chipsSelectedList)
                    }
                    defer.await()
                }
            }
        )
        {
            Text("Node Run projects")
        }

        Spacer(Modifier.width(20.dp))

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = getNodeTestActionButtonsColour(),
            onClick = {
                coroutineScope.launch {
                    val defer = async(Dispatchers.IO) {
                        val chips = chipsSelected.filter { it -> it.value }
                        val chipsSelectedList = chips.keys.toList()
                        antUseCase.nodeRunTestMicroFList(chipsSelectedList)
                    }
                    defer.await()
                }
            }
        )
        {
            Text("Node Test projects")
        }
    }
}