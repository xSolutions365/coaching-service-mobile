package com.createfuture.coaching.service.data

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

expect val httpClientEngineFactory: HttpClientEngineFactory<*>

val networkingModule = module {
    single {
        HttpClient(httpClientEngineFactory) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(
                    Json { ignoreUnknownKeys = true }
                )
            }
        }
    }
}
