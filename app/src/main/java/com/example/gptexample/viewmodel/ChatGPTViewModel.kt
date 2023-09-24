package com.example.gptexample.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.gptexample.Model.ChatGPTResponse
import com.example.gptexample.repository.ChatGPTRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.HttpException
import javax.inject.Inject

class ChatGPTViewModel(private val repository: ChatGPTRepository) : ViewModel() {

    suspend fun getChatResponse(prompt: String): ChatGPTResponse {
        return repository.getChatResponse(prompt)
    }
}
