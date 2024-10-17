package api.model

import kotlinx.serialization.Serializable

@Serializable
data class Cometh(
    val row: Int,
    val column: Int,
    val direction: String,
    val candidateId: String? = null
)