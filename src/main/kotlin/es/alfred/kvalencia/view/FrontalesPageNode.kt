package es.alfred.kvalencia.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * @author Alfredo Sanz
 * @time 2023
 */
class FrontalesPageNode {

    private val frontNodepageRow01: FrontalesPageNodeRun01Row = FrontalesPageNodeRun01Row();

    @Composable
    fun createPage() {

        Spacer(Modifier.width(20.dp))
        frontNodepageRow01.getNodeRunRow01()
    }
}