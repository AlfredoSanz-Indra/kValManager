package es.alfred.kvalencia.view.page

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import es.alfred.kvalencia.core.di.UseCaseFactory
import es.alfred.kvalencia.domain.usecaseapi.AntUseCase
import es.alfred.kvalencia.domain.usecaseapi.MongoOperations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * @author Alfredo Sanz
 * @time 2023
 */
class FrontalesPageMongo {

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
        val mongoOperations: MongoOperations = UseCaseFactory.getMongoOperations()

        var mongoIsAlive by remember { mutableStateOf(TextFieldValue("Undetermined")) }

        val coroutineScope = rememberCoroutineScope()
        val interactionSource = remember { MutableInteractionSource() }
        val isPressed by interactionSource.collectIsPressedAsState()
        val color = if (isPressed) Color(0xFF949601) else Color(0xFF849601)
        val borderColor = if (isPressed) Color.Black else Color(0xFF666699)

        OutlinedButton(modifier = Modifier.width(250.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = color,
                contentColor = Color(0xFFF5F5F5),
                disabledContentColor = Color(0XFFe83151),
                disabledContainerColor = Color(0XFFe83151)
            ),
            border = ButtonDefaults.outlinedButtonBorder.copy(brush = androidx.compose.ui.graphics.Brush.horizontalGradient(listOf(borderColor, borderColor))),
            interactionSource = interactionSource,
            onClick = {
                coroutineScope.launch {
                    val defer = async(Dispatchers.IO) {
                        antUseCase.mongoRunServer()
                    }
                    defer.await()
                }
            }
        )
        {
            Text("Run Mongo Server")
        }

        Spacer(Modifier.width(20.dp))

        OutlinedButton(modifier = Modifier.width(250.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = color,
                contentColor = Color(0xFFF5F5F5),
                disabledContentColor = Color(0XFFe83151),
                disabledContainerColor = Color(0XFFe83151)
            ),
            border = ButtonDefaults.outlinedButtonBorder.copy(brush = androidx.compose.ui.graphics.Brush.horizontalGradient(listOf(borderColor, borderColor))),
            interactionSource = interactionSource,
            onClick = {
                coroutineScope.launch {
                    val defer = async(Dispatchers.IO) {
                        mongoIsAlive = TextFieldValue("Checking ...")
                        val resp = mongoOperations.isAlive()

                        return@async resp
                    }
                    val result = defer.await()

                    mongoIsAlive = if(result.result) {
                        TextFieldValue("Is Alive")
                    }
                    else {
                        TextFieldValue("is Offline")
                    }
                }
            }
        )
        {
            Text("Test is Alive")
        }

        Spacer(Modifier.width(20.dp))

        Text(
            text= mongoIsAlive.text,
            color = if(mongoIsAlive.text == "is Offline") {
                        Color.Red
                    } else {
                        Color.Black
                    }
            )
    }
}