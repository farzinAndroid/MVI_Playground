package com.farzin.mvi_playground.view

import androidx.compose.runtime.Composable
import com.farzin.mvi_playground.viewmodel.MainViewModel

@Composable
fun MainScreen(vm:MainViewModel,onButtonClicked:()->Unit) {

    val state = vm.state.value

    when(state){
        MainState.Idle -> IdleScreen(onButtonClicked)
        MainState.Loading -> LoadingScreen()
        is MainState.Success -> SuccessScreen(state.animals)
        is MainState.Error -> {
            IdleScreen(onButtonClicked)
        }
    }
}