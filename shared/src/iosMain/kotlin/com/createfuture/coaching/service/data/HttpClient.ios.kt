package com.createfuture.coaching.service.data

import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin

actual val httpClientEngineFactory: HttpClientEngineFactory<*> = Darwin