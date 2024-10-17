package org.example.api

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class HttpSource {
    val client by lazy {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
            install(HttpTimeout) {
                requestTimeoutMillis = TIME_OUT
                connectTimeoutMillis = TIME_OUT
                socketTimeoutMillis = TIME_OUT
            }

            install(HttpRedirect) {
                checkHttpMethod = false
            }

            install(HttpRequestRetry) {
                retryOnServerErrors(RETRIES)
                retryOnException(RETRIES, true)
            }
            BrowserUserAgent()
            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
            install(Logging) {
                level = LogLevel.ALL
            }

        }
    }

    companion object {
        const val TIME_OUT = 5_000L
        const val RETRIES = 3
    }
}