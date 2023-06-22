package com.zekure.poemsforeveryone.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.zekure.poemsforeveryone.PoemApplication
import com.zekure.poemsforeveryone.data.NetworkPoemRepository
import com.zekure.poemsforeveryone.network.Poem
import kotlinx.coroutines.launch
import java.io.IOException

class PoemViewModel(private val poemRepository: NetworkPoemRepository): ViewModel() {
    var poemUiState: PoemUiState by mutableStateOf(PoemUiState.Loading)
        private set

    init {
        getRandomPoem()
    }

    fun getRandomPoem() {
        viewModelScope.launch {
            poemUiState = try {
                val result = poemRepository.getRandomPoem()[0]
                PoemUiState.Success(result)
            } catch (e: IOException) {
                PoemUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PoemApplication)
                val poemRepository = application.container.poemRepository
                PoemViewModel(poemRepository = poemRepository as NetworkPoemRepository)
            }
        }
    }

}

sealed interface PoemUiState {
    data class Success(val poem: Poem): PoemUiState
    object Error: PoemUiState
    object Loading: PoemUiState
}