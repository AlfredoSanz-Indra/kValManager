package es.alfred.kvalencia.view.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
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
class FrontalesPageTests {

    @Composable
    fun createPage() {

        Spacer(Modifier.height(20.dp))

        Row(Modifier.background(color = Color.White).width(800.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            row01()
        }
    }

    @Composable
    private fun row01() {
        val antUseCase: AntUseCase = UseCaseFactory.getAntUseCase()
        val coroutineScope = rememberCoroutineScope()
        val buttonsColours = ButtonDefaults.outlinedButtonColors(
            containerColor = Color(0xFF336699),
            contentColor = Color(0xFFF5F5F5),
            disabledContentColor = Color(0XFFe83151),
            disabledContainerColor = Color(0XFFe83151)
        )

        OutlinedButton(modifier = Modifier.width(250.dp),
            colors = buttonsColours,
            onClick = {
                coroutineScope.launch {
                    val defer = async(Dispatchers.IO) {
                        antUseCase.coroutineTest("**")
                    }
                    defer.await()
                }
            }
        )
        {
            Text("Coroutine test")
        }

        Spacer(Modifier.width(20.dp))

        OutlinedButton(modifier = Modifier.width(250.dp),
            colors = buttonsColours,
            onClick = {
                coroutineScope.launch {
                    val defer = async(Dispatchers.IO) {
                        antUseCase.coroutineTestReturn("**")
                    }
                    var result = defer.await()
                    println(result.toString() + " Alfred amazing")
                }
            }
        )
        {
            Text("Coroutine test return data")
        }
    }
}