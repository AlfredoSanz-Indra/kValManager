package es.alfred.kvalencia.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import es.alfred.kvalencia.core.Constants
import es.alfred.kvalencia.core.resources.TheResources
import es.alfred.kvalencia.view.page.FrontalesPageGit
import es.alfred.kvalencia.view.page.FrontalesPageNode
import es.alfred.kvalencia.view.page.FrontalesPageTests
import es.alfred.kvalencia.view.page.section.FrontalesPageMainButtons


/**
 * @author Alfredo Sanz
 * @time 2023
 */
class FrontalesView : IView {

    private val frontPageMainButtonsRow: FrontalesPageMainButtons = FrontalesPageMainButtons()
    private val frontPageGit: FrontalesPageGit = FrontalesPageGit()
    private val frontPageNode: FrontalesPageNode = FrontalesPageNode()
    private val frontPageTests: FrontalesPageTests = FrontalesPageTests()

    var chipsGitSelected: MutableMap<String, Boolean> = mutableMapOf()
    var chipsNodeSelected: MutableMap<String, Boolean> = mutableMapOf()

    constructor() {
        initGlobal()
    }

    private fun initGlobal() {
        TheResources.getProjects().projects
            .forEach { it -> chipsGitSelected[it.task] = false }

        TheResources.getProjects().projects
            .filter { it -> it.runnable }
            .forEach { it -> chipsNodeSelected[it.task] = false }
    }

    @Preview
    @Composable
    override fun createView() {

        var theview: Byte by remember { mutableStateOf(0) }
        var curView:Byte by remember { mutableStateOf(theview) }

        MaterialTheme(darkColorScheme(background = Color.Black)) {
            Column {
                Row(
                    Modifier.background(color = Color(0xFFF8F7FF))
                        .height(130.dp)
                        .width(800.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    frontPageMainButtonsRow.createPage(onViewChange = {theview = it})
                }

                if(curView != theview) {
                    initGlobal()
                    curView = theview
                }

                if (Constants.theviewGit == theview) {
                    frontPageGit.createPage(chipsGitSelected)
                }

                if (Constants.theviewNode == theview) {
                    frontPageNode.createPage(chipsNodeSelected)
                }

                if (Constants.theviewTests == theview) {
                    frontPageTests.createPage()
                }
            }
        }
    }
}