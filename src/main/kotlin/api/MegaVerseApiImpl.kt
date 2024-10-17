package org.example.api

import api.model.Cometh
import api.model.Goal
import api.model.Soloon
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import org.example.api.model.Polyanet
import result.Result

class MegaVerseApiImpl(
    private val httpSource: HttpSource,
) : MegaVerseApi {

    override suspend fun getGoalMap(): Result<Goal> {
        return runCatching {
            httpSource
                .client
                .get("${BASE_URL}map/$CANDIDATE_ID/goal")
                .body<Goal>()
        }.fold(
            onFailure = { failure -> Result.Error(failure) },
            onSuccess = { result -> Result.Success(result) }
        )
    }

    override suspend fun createPolyanet(row: Int, column: Int): Result<HttpResponse> {
        return runCatching {
            httpSource
                .client
                .post("${BASE_URL}polyanets") {
                    contentType(ContentType.Application.Json)
                    setBody(
                        Polyanet(
                            row = row,
                            column = column,
                            candidateId = CANDIDATE_ID
                        )
                    )
                }
        }.fold(
            onFailure = { failure -> Result.Error(failure) },
            onSuccess = { result -> Result.Success(result) }
        )
    }

    override suspend fun createSoloon(row: Int, column: Int, color: String): Result<HttpResponse> {
        return runCatching {
            httpSource
                .client
                .post("${BASE_URL}soloons") {
                    contentType(ContentType.Application.Json)
                    setBody(
                        Soloon(
                            row = row,
                            column = column,
                            color = color,
                            candidateId = CANDIDATE_ID
                        )
                    )
                }
        }.fold(
            onFailure = { failure -> Result.Error(failure) },
            onSuccess = { result -> Result.Success(result) }
        )
    }

    override suspend fun createCometh(row: Int, column: Int, direction: String): Result<HttpResponse> {
        return runCatching {
            httpSource
                .client
                .post("${BASE_URL}comeths") {
                    contentType(ContentType.Application.Json)
                    setBody(
                        Cometh(
                            row = row,
                            column = column,
                            direction = direction,
                            candidateId = CANDIDATE_ID
                        )
                    )
                }
        }.fold(
            onFailure = { failure -> Result.Error(failure) },
            onSuccess = { result -> Result.Success(result) }
        )
    }

    companion object {
        const val BASE_URL = "https://challenge.crossmint.io/api/"
        const val CANDIDATE_ID = "5135b2c0-2ac6-40be-a184-2b197c17a8a3"
    }
}