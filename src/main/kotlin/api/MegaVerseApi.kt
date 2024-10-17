package org.example.api

import api.model.Goal
import io.ktor.client.statement.*
import result.Result

interface MegaVerseApi {
    suspend fun getGoalMap(): Result<Goal>
    suspend fun createPolyanet(row: Int, column: Int): Result<HttpResponse>
    suspend fun createSoloon(row: Int, column: Int, color: String): Result<HttpResponse>
    suspend fun createCometh(row: Int, column: Int, direction: String): Result<HttpResponse>
}