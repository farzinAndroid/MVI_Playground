package com.farzin.mvi_playground.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.farzin.mvi_playground.api.AnimalApi
import com.farzin.mvi_playground.api.AnimalRepo
import java.lang.IllegalArgumentException


class ViewModelFactory(private val api: AnimalApi) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(AnimalRepo(api)) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}