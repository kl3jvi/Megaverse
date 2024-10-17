package api.model

import kotlinx.serialization.Serializable

@Serializable
data class Goal(
    val goal: List<List<String>>
)