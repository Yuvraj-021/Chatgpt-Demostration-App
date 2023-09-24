package com.example.gptexample.Model

data class ChatGPTRequest(val prompt: String ,val model:String="gpt-3.5-turbo-instruct", val max_tokens:Int=7)
data class ChatGPTResponse(val choices: List<Choice>)
data class Choice(val text: String)