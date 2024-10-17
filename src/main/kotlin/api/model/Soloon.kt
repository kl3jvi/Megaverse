package api.model

import kotlinx.serialization.Serializable

@Serializable
data class Soloon(
    val row: Int,
    val column: Int,
    val color: String,
    val candidateId: String? = null
)