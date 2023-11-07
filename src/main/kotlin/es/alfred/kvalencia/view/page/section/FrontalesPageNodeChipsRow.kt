package es.alfred.kvalencia.view.page.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import es.alfred.kvalencia.core.Util
import es.alfred.kvalencia.core.model.Project
import es.alfred.kvalencia.core.resources.TheResources

/**
 * @author Alfredo Sanz
 * @time 2023
 */
class FrontalesPageNodeChipsRow {

    @Composable
    fun nodeChipsRow(chipsSelected: MutableMap<String, Boolean>) {

        val items: List<Any> = TheResources.getProjects().projects.filter{ it -> it.runnable }
        val itemsGroup: List<List<Any>> = Util.groupItems(items, 4)

        for(group in itemsGroup) {
            Row(
                Modifier.background(color = Color.White).width(800.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(Modifier.width(20.dp))

                for(item in group) {
                    nodeChip(item as Project, chipsSelected)
                }
            }//row
        }//for
    }

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
    @Composable
    private fun nodeChip(item: Project, chipsSelected: MutableMap<String, Boolean>) {

        var selected by remember { mutableStateOf(false) }

        FilterChip(
            selected = selected,
            onClick = {
                selected = !selected
                chipsSelected[item.task] = selected
            },
            label = { Text(item.label) },
            modifier = Modifier,
            colors = FilterChipDefaults.filterChipColors(
                containerColor = Color(0xFF336699),
                labelColor = Color.White,
                selectedContainerColor = Color(0XFFe83151),
                selectedLabelColor = Color.White
            ),
            leadingIcon = {
                Icon(
                    when (selected) {
                        true -> Icons.Filled.Check
                        false -> Icons.Filled.Add
                    },
                    contentDescription = item.name,
                    Modifier.size(FilterChipDefaults.IconSize)
                )
            },
        )//Chips
        Spacer(Modifier.width(20.dp))
    }
}