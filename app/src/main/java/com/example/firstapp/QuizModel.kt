package com.example.firstapp

data class QuizModel(
    val id : String,
    val title : String,
    val subtitle : String,
    val time : String,
    val questionlist:List<questionModel>
){
    constructor() : this("","","","", emptyList())
}

data class questionModel(
    val question : String,
    val options : List<String>,
    val correct : String
){
    constructor(): this ("", emptyList(), "")
}