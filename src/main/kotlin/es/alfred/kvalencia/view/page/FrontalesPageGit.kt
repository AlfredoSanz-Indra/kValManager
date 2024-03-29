package es.alfred.kvalencia.view.page

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import es.alfred.kvalencia.view.page.section.FrontalesPageGitChipsActionButtonsRow
import es.alfred.kvalencia.view.page.section.FrontalesPageGitChipsRow
import es.alfred.kvalencia.view.page.section.FrontalesPageGitPullButtonsRow

/**
 * @author Alfredo Sanz
 * @time 2023
 */
class FrontalesPageGit {

    private val frontpageGitPullButtonsRow: FrontalesPageGitPullButtonsRow = FrontalesPageGitPullButtonsRow();
    private val frontpageGitChipRow: FrontalesPageGitChipsRow = FrontalesPageGitChipsRow()
    private val frontpageGitChipActionButtons: FrontalesPageGitChipsActionButtonsRow = FrontalesPageGitChipsActionButtonsRow()

    @Composable
    fun createPage( chipsSelected: MutableMap<String, Boolean>) {

        Spacer(Modifier.height(20.dp))
        this.frontpageGitPullButtonsRow.gitpullsButtonRow()

        Spacer(Modifier.height(20.dp))
        this.frontpageGitChipRow.gitChipsRow(chipsSelected)

        Spacer(Modifier.height(20.dp))
        this.frontpageGitChipActionButtons.gitChipsActionsRow(chipsSelected)
    }
}