package com.example.lemonade.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LemonadeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LemonadeUiState())
    val uiState: StateFlow<LemonadeUiState> = _uiState.asStateFlow()

    fun navigateNext() {
        _uiState.value = _uiState.value.copy(
            currentStep = if (_uiState.value.currentStep < 4) _uiState.value.currentStep + 1 else 1
        )
    }

    fun navigatePrevious() {
        _uiState.value = _uiState.value.copy(
            currentStep = if (_uiState.value.currentStep > 1) _uiState.value.currentStep - 1 else 4
        )
    }

    fun updateUserInput(input: String) {
        _uiState.value = _uiState.value.copy(userInput = input)
    }

    fun checkAnswer() {
        val correctAnswer = uiState.value.personas[uiState.value.currentStep - 1]
        _uiState.value = _uiState.value.copy(
            feedback = if (uiState.value.userInput == correctAnswer) "Correcto" else "Incorrecto"
        )
    }

    fun showSolution() {
        val correctAnswer = uiState.value.personas[uiState.value.currentStep - 1]
        _uiState.value = _uiState.value.copy(
            feedback = "La solución es: $correctAnswer"
        )
    }
}