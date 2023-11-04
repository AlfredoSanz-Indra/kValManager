package es.alfred.kvalencia.core.model

import kotlinx.serialization.Serializable

/**
 * @author Alfredo Sanz
 * @time 2023
 */
@Serializable
data class Projects(@Serializable() val projects: List<Project> )