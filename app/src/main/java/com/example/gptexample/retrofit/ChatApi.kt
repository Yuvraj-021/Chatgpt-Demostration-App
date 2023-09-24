package com.example.gptexample.retrofit

import com.example.gptexample.Model.ChatGPTRequest
import com.example.gptexample.Model.ChatGPTResponse
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ChatApi {
    @Headers(
        "Authorization: Bearer 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",
        "Content-Type: application/json"
    )
    @POST("completions")
    suspend fun getChatResponse(@Body request: ChatGPTRequest):ChatGPTResponse
}