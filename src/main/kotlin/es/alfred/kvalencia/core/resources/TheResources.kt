package es.alfred.kvalencia.core.resources

import es.alfred.kvalencia.core.model.Projects

/**
 * @author Alfredo Sanz
 * @time 2023
 */
object TheResources {

    private lateinit var projects: Projects

    fun getProjects(): Projects {
        if (!this::projects.isInitialized) {
            this.projects = readJsonResources_projects("projects.json")
        }
        return this.projects
    }
}