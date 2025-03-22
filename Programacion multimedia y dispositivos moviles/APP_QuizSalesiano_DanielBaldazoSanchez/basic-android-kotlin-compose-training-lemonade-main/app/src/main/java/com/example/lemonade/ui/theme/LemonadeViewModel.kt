package com.example.lemonade.ui.theme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// ViewModel que gestiona el estado y la lógica de la aplicación
class LemonadeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LemonadeUiState())

    val uiState: StateFlow<LemonadeUiState> = _uiState.asStateFlow()

    // Función para avanzar a la siguiente iteración
    fun moveToNextStep() {
        _uiState.value = _uiState.value.copy(
            currentStep = if (_uiState.value.currentStep < 4) _uiState.value.currentStep + 1 else 1,
            feedback = "",
            userInput = ""
        )
    }

    // Función para retroceder a la iteración anterior
    fun moveToPreviousStep() {
        _uiState.value = _uiState.value.copy(
            currentStep = if (_uiState.value.currentStep > 1) _uiState.value.currentStep - 1 else 4,
            feedback = "",
            userInput = ""
        )
    }


    fun updateUserInput(input: String) {
        _uiState.value = _uiState.value.copy(userInput = input)
    }

    // Verificamos si el usuario ha acertado
    fun checkAnswer() {
        // Obtiene la respuesta correcta para la iteración
        val correctAnswer = _uiState.value.personas[_uiState.value.currentStep - 1]
        _uiState.value = _uiState.value.copy(
            // Actualiza el si es correco o incorrecto
            feedback = if (_uiState.value.userInput == correctAnswer) "Correcto" else "Incorrecto"
        )
    }

    // Muestra la solución correcta para la iteración de ahora
    fun showSolution() {
        val correctAnswer = _uiState.value.personas[_uiState.value.currentStep - 1]
        _uiState.value = _uiState.value.copy(
            // Muestra la solución como feedback
            feedback = "La solución es: $correctAnswer"
        )
    }
}
