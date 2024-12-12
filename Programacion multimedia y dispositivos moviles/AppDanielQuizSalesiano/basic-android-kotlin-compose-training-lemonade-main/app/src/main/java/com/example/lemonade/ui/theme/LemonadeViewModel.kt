package com.example.lemonade.ui.theme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LemonadeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LemonadeUiState())
    val uiState: StateFlow<LemonadeUiState> = _uiState.asStateFlow()

    // Maneja el cambio de texto ingresado por el usuario
    fun onUserInputChange(input: String) {
        _uiState.value = _uiState.value.copy(userInput = input)
    }

    fun handlePrevious() {
        _uiState.value = _uiState.value.copy(
            screen = if (_uiState.value.screen > 1) _uiState.value.screen - 1 else 4
        )
    }

    fun handleNext() {
        _uiState.value = _uiState.value.copy(
            screen = if (_uiState.value.screen < 4) _uiState.value.screen + 1 else 1
        )
    }

    fun checkAnswer() {
        val correctAnswer = listOf("Domingo Savio", "Don Bosco", "Mama Margarita", "Maria Auxiliadora")
        val feedback = if (_uiState.value.userInput == correctAnswer[_uiState.value.screen - 1]) {
            "Correcto"
        } else {
            "Incorrecto"
        }
        _uiState.value = _uiState.value.copy(feedback = feedback)
    }

    fun showSolution() {
        val correctAnswer = listOf("Domingo Savio", "Don Bosco", "Mama Margarita", "Maria Auxiliadora")
        _uiState.value = _uiState.value.copy(feedback = "La solución es: ${correctAnswer[_uiState.value.screen - 1]}")
    }
}
