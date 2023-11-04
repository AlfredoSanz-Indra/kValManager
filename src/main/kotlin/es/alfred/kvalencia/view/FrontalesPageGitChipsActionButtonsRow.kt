package es.alfred.kvalencia.view

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
class FrontalesPageGitChipsActionButtonsRow {

    private val antUseCase: AntUseCase = UseCaseFactory.getAntUseCase()

    @Composable
    private fun getGitActionButtonsColour(): ButtonColors {
        val result = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF1AA161),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0xFF66DD99))

        return result
    }

    @Composable
    fun gitChipsActionsRow(chipsSelected: MutableMap<String, Boolean>) {

        Row(
            Modifier.background(color = Color.White).width(800.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.width(20.dp))
            gitpullActionButton(chipsSelected)
        }
    }

    @Composable
    private fun gitpullActionButton(chipsSelected: MutableMap<String, Boolean>) {

        val coroutineScope = rememberCoroutineScope()

        OutlinedButton(modifier = Modifier.width(200.dp),
            colors = getGitActionButtonsColour(),
            onClick = {
                coroutineScope.launch {
                    val defer = async(Dispatchers.IO) {
                        println("**chipsSelected: $chipsSelected")
                        val chips = chipsSelected.filter { it -> it.value }
                        println("**chips: $chips")
                        val chipsSelectedList = chips.keys.toList()
                        println("**chipsSelected: $chipsSelectedList")
                        antUseCase.gitPullList(chipsSelectedList)
                    }
                    defer.await()
                }
            }
        )
        {
            Text("Git pull projects")
        }
    }
}