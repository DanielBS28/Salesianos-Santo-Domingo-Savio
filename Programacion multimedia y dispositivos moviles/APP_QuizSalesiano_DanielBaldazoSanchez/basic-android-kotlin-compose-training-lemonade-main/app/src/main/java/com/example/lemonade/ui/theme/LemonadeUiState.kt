package com.example.lemonade.ui.theme

// Data class que define el estado de la aplicación Lemonade
data class LemonadeUiState(
    // Paso actual en el flujo de la aplicación, comienza en 1
    val currentStep: Int = 1,

    // Entrada del usuario, que contiene el texto ingresado en el campo de texto
    val userInput: String = "",

    // Feedback para el usuario, que muestra si su respuesta es "Correcto", "Incorrecto", o la solución
    val feedback: String = "",

    // Lista de nombres que representan las respuestas correctas para cada paso
    val personas: List<String> = listOf(
        "Domingo Savio",      // Respuesta para el paso 1
        "Don Bosco",          // Respuesta para el paso 2
        "Mama Margarita",     // Respuesta para el paso 3
        "Maria Auxiliadora"   // Respuesta para el paso 4
    )
)
