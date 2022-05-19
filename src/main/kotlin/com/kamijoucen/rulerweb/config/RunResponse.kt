package com.kamijoucen.rulerweb.config

data class RunResponse(
    val result: Map<String, Any> = HashMap(),
    val time: Long = -1
)