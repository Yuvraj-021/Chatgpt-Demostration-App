package com.example.gptexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gptexample.repository.ChatGPTRepository
import javax.inject.Inject

class ChatGPTViewModelFactory @Inject constructor(private val repository: ChatGPTRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChatGPTViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ChatGPTViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
