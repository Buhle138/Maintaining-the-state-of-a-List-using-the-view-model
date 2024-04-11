package com.example.addingcategories

import androidx.compose.runtime.mutableStateListOf

data class MyScreenState(
    var textState: String = "",
    var namesList: List<String> = mutableListOf()
)
