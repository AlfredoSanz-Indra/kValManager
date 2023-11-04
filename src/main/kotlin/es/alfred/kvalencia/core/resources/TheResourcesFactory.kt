package es.alfred.kvalencia.core.resources

import es.alfred.kvalencia.core.model.Projects
import java.io.InputStream
import kotlinx.serialization.json.*

/**
 * @author Alfredo Sanz
 * @time 2023
 */


fun readJsonResources_projects(fileName: String): Projects {
    val loader = Thread.currentThread().contextClassLoader
    val input: InputStream = loader.getResourceAsStream(fileName)

    val result = Json.decodeFromStream<Projects>(input)
    return result
}
