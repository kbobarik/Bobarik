package com.exaple.api.api

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun sendCodeEmail(email:String): Flow<Result<String>>
}