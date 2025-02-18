import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import es.alfred.kvalencia.view.FrontalesView
import es.alfred.kvalencia.view.IView


const val actionFrontales: String = "FRONTALES"


/**
 * @author Alfredo Sanz
 * @date Oct 2023
 */
@Composable
private fun app(action: String) {

    var v: IView

    when(action) {
        actionFrontales -> {
            v = FrontalesView()
            v.createView()
        }
    }
}

fun main() = application {
    var action by remember { mutableStateOf(actionFrontales) }

    Window(onCloseRequest = ::exitApplication,
        title = "KManager 1.1.5",
        state = rememberWindowState(width = 850.dp, height = 710.dp)
    ) {
        MenuBar {
            Menu("Options list", mnemonic = 'F') {
                Item("Frontales", onClick = { action = actionFrontales }, shortcut = KeyShortcut(Key.C, ctrl = true))
            }
        }
        app(action)
    }
}
