package com.example.lemonade.ui

import com.example.lemonade.R

data class LemonadeUiState(
    val currentStep: Int = 1,
    val userInput: String = "",
    val feedback: String = "",
    val personas: List<String> = listOf(
        "Domingo Savio",
        "Don Bosco",
        "Mama Margarita",
        "Maria Auxiliadora"
    ),
    val drawableResourceId: Int = R.drawable.domingo_savio
)
