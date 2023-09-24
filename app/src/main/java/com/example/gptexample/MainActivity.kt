package com.example.gptexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.gptexample.Model.ChatGPTRequest
import com.example.gptexample.databinding.ActivityMainBinding
import com.example.gptexample.di.NetworkModule
import com.example.gptexample.repository.ChatGPTRepository
import com.example.gptexample.viewmodel.ChatGPTViewModel
import com.example.gptexample.viewmodel.ChatGPTViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ChatGPTViewModel

    @Inject
    lateinit var mainviewModelFactory: ChatGPTViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        (application as ChatApplication).applicationComponent.inject(this)

        viewModel = ViewModelProvider(this,mainviewModelFactory).get(ChatGPTViewModel::class.java)

        binding.btnsubmit.setOnClickListener{
            val s:String = binding.txtquestion.text.toString()
            runBlocking {
                val response = viewModel.getChatResponse(s)
                binding.txtResponse.text=response.toString()
            }

        }
    }
}