package com.farzin.mvi_playground.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farzin.mvi_playground.api.AnimalRepo
import com.farzin.mvi_playground.view.MainIntent
import com.farzin.mvi_playground.view.MainState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repo: AnimalRepo) : ViewModel() {

    // channel is part of coroutines to pass information to viewModel
    val userIntent = Channel<MainIntent>(Channel.UNLIMITED)

    var state = mutableStateOf<MainState>(MainState.Idle)
        private set


    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect { collector ->
                when (collector) {
                    is MainIntent.fetchAnimals -> fetchAnimals()
                }
            }
        }
    }


    private fun fetchAnimals() {
        viewModelScope.launch {
            state.value = MainState.Loading
            try {
                state.value = MainState.Success(repo.getAnimals())
            } catch (e: Exception) {
                state.value = MainState.Error(e.localizedMessage)
            }
        }
    }

}





