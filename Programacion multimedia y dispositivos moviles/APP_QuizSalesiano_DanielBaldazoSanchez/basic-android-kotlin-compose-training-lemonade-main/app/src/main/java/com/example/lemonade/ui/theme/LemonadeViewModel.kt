package com.example.lemonade.ui.theme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// ViewModel que gestiona el estado y la lógica de la aplicación Lemonade
class LemonadeViewModel : ViewModel() {
    // Estado interno mutable de la aplicación (privado)
    private val _uiState = MutableStateFlow(LemonadeUiState())

    // Estado público expuesto como flujo inmutable para ser observado por la UI
    val uiState: StateFlow<LemonadeUiState> = _uiState.asStateFlow()

    // Función para avanzar al siguiente paso
    fun moveToNextStep() {
        _uiState.value = _uiState.value.copy(
            currentStep = if (_uiState.value.currentStep < 4) _uiState.value.currentStep + 1 else 1,
            // Reinicia feedback y entrada del usuario al cambiar de paso
            feedback = "",
            userInput = ""
        )
    }

    // Función para retroceder al paso anterior
    fun moveToPreviousStep() {
        _uiState.value = _uiState.value.copy(
            currentStep = if (_uiState.value.currentStep > 1) _uiState.value.currentStep - 1 else 4,
            // Reinicia feedback y entrada del usuario al cambiar de paso
            feedback = "",
            userInput = ""
        )
    }

    // Actualiza la entrada del usuario en el estado
    fun updateUserInput(input: String) {
        _uiState.value = _uiState.value.copy(userInput = input)
    }

    // Verifica si la entrada del usuario es correcta
    fun checkAnswer() {
        // Obtiene la respuesta correcta para el paso actual
        val correctAnswer = _uiState.value.personas[_uiState.value.currentStep - 1]
        _uiState.value = _uiState.value.copy(
            // Actualiza el feedback con "Correcto" o "Incorrecto"
            feedback = if (_uiState.value.userInput == correctAnswer) "Correcto" else "Incorrecto"
        )
    }

    // Muestra la solución correcta para el paso actual
    fun showSolution() {
        // Obtiene la respuesta correcta para el paso actual
        val correctAnswer = _uiState.value.personas[_uiState.value.currentStep - 1]
        _uiState.value = _uiState.value.copy(
            // Muestra la solución como feedback
            feedback = "La solución es: $correctAnswer"
        )
    }
}
