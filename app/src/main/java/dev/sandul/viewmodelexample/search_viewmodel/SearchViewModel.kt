package dev.sandul.viewmodelexample.search_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState

    fun searchUsers(query: String) {
        viewModelScope.launch {
            _uiState.value = SearchUiState(isLoading = true)
            try {
                delay(1500)
                if (query.isBlank()) {
                    _uiState.value = SearchUiState(error = "Write user name")
                } else {
                    val users = listOf(
                        User(1, "Oleksandr"),
                        User(2, "Ivan"),
                        User(3, "Anna"),
                        User(4, "Dmytro"),
                        User(5, "Alex"),
                        User(6, "Tetiana")
                    ).filter { it.name.contains(query, ignoreCase = true) }

                    _uiState.value = if (users.isEmpty()) {
                        SearchUiState(error = "no users with this name")
                    } else {
                        SearchUiState(users = users)
                    }
                }

            } catch (e: Exception) {
                _uiState.value = SearchUiState(error = "Error ${e.localizedMessage}")
            }
        }
    }
}