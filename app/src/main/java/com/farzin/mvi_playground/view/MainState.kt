package com.farzin.mvi_playground.view

import com.farzin.mvi_playground.model.Animal

sealed class MainState {

    data object Idle : MainState()
    data object Loading : MainState()
    data class Success(val animals: List<Animal>) : MainState()
    data class Error(val error: String?) : MainState()

}