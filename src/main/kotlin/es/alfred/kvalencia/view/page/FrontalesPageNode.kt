package es.alfred.kvalencia.view.page

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import es.alfred.kvalencia.view.page.section.FrontalesPageNodeChipsButtonsRow
import es.alfred.kvalencia.view.page.section.FrontalesPageNodeChipsRow
import es.alfred.kvalencia.view.page.section.FrontalesPageNodeRun01Row

/**
 * @author Alfredo Sanz
 * @time 2023
 */
class FrontalesPageNode {

    private val frontNodepageRow01: FrontalesPageNodeRun01Row = FrontalesPageNodeRun01Row()
    private val frontNodepageChipsRow: FrontalesPageNodeChipsRow = FrontalesPageNodeChipsRow()
    private val frontNodepageChiposButtonsRow: FrontalesPageNodeChipsButtonsRow = FrontalesPageNodeChipsButtonsRow()

    @Composable
    fun createPage(chipsSelected: MutableMap<String, Boolean>) {

        Spacer(Modifier.height(20.dp))
        frontNodepageRow01.getNodeRunRow01()

        Spacer(Modifier.height(20.dp))
        frontNodepageChipsRow.nodeChipsRow(chipsSelected)

        Spacer(Modifier.height(40.dp))
        frontNodepageChiposButtonsRow.nodeChipsActionsRow(chipsSelected)
    }
}