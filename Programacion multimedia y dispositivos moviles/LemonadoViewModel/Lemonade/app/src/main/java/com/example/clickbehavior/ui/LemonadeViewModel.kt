package com.example.clickbehavior.ui
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LemonadeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LemonadeUiState())
    val uiState: StateFlow<LemonadeUiState> = _uiState.asStateFlow()

    fun handleClick() {
        _uiState.value = _uiState.value.let { currentState ->
            when (currentState.screen) {
                1 -> currentState.copy(
                    screen = 2,
                    squeeze = (1..10).random(),
                    squeezeCount = 0
                )
                2 -> if (currentState.squeezeCount < currentState.squeeze - 1) {
                    currentState.copy(squeezeCount = currentState.squeezeCount + 1)
                } else {
                    currentState.copy(screen = 3)
                }
                3 -> currentState.copy(screen = 4)
                else -> currentState.copy(screen = 1)
            }
        }
    }
}
