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
    fun getNodeRunRow01() {

        Row(
            Modifier.background(color = Color.White).width(800.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.width(20.dp))
        }
    }
}