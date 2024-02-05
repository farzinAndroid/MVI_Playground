package com.farzin.mvi_playground.view

sealed class MainIntent {

    data object fetchAnimals : MainIntent()


}