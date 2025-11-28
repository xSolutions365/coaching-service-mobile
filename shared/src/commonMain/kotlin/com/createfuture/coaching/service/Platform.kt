package com.createfuture.coaching.service

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform