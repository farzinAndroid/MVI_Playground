package com.farzin.mvi_playground

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.farzin.mvi_playground.api.AnimalService
import com.farzin.mvi_playground.ui.theme.MVI_PlaygroundTheme
import com.farzin.mvi_playground.view.MainIntent
import com.farzin.mvi_playground.view.MainScreen
import com.farzin.mvi_playground.viewmodel.MainViewModel
import com.farzin.mvi_playground.viewmodel.ViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel by viewModels<MainViewModel> {
            ViewModelFactory(AnimalService.api)
        }

        val onButtonClicked: () -> Unit = {
            lifecycleScope.launch {
                mainViewModel.userIntent.send(MainIntent.fetchAnimals)
            }
        }

        setContent {
            MVI_PlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    MainScreen(vm = mainViewModel, onButtonClicked = onButtonClicked)

                }
            }
        }
    }
}






