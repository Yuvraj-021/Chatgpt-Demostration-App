package com.example.gptexample.repository

import com.example.gptexample.Model.ChatGPTRequest
import com.example.gptexample.Model.ChatGPTResponse
import com.example.gptexample.retrofit.ChatApi
import javax.inject.Inject

class ChatGPTRepository @Inject constructor(private val api: ChatApi) {

    suspend fun getChatResponse(prompt: String): ChatGPTResponse {
        return api.getChatResponse(ChatGPTRequest(prompt))
    }

}