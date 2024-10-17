package org.example.api.model

import kotlinx.serialization.Serializable

@Serializable
data class Polyanet(
    val row: Int,
    val column: Int,
    val candidateId: String? = null
)

