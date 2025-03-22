package com.example.lemonade.ui.theme

data class LemonadeUiState(
    // Paso actual en la aplicación del UI State
    val currentStep: Int = 1,

    val userInput: String = "",

    val feedback: String = "",

    // Lista de fotografías que aparecen en la app
    val personas: List<String> = listOf(
        "Domingo Savio",
        "Don Bosco",
        "Mama Margarita",
        "Maria Auxiliadora"
    )
)
