package com.zekure.poemsforeveryone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zekure.poemsforeveryone.ui.screens.PoemUiState
import com.zekure.poemsforeveryone.ui.screens.PoemViewModel
import com.zekure.poemsforeveryone.ui.theme.PoemsForEveryoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PoemsForEveryoneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val poemViewModel: PoemViewModel = viewModel(factory = PoemViewModel.Factory)
                    val poemUiState: PoemUiState = poemViewModel.poemUiState
                    when(poemUiState) {
                        is PoemUiState.Success -> Greeting(poemUiState.poem.lines[0])
                        else -> Greeting("Android")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PoemsForEveryoneTheme {
        Greeting("Android")
    }
}