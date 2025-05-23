package dev.sandul.viewmodelexample.search_user.search_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.sandul.viewmodelexample.search_user.search_repository.SearchUserRepository
import dev.sandul.viewmodelexample.search_user.search_repository.SearchUserRepositoryImlp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: SearchUserRepository = SearchUserRepositoryImlp()
) : ViewModel() {
    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState

    fun searchUsers(query: String) {
        viewModelScope.launch {
            _uiState.value = SearchUiState(isLoading = true)
            try {
                val users = repository.searchUsers(query)
                _uiState.value = when {
                    query.isBlank() -> SearchUiState(error = "Enter user name")
                    users.isEmpty() -> SearchUiState(error = "No users with this name")
                    else -> SearchUiState(users = users)
                }

            } catch (e: Exception) {
                _uiState.value = SearchUiState(error = "Error ${e.localizedMessage}")
            }
        }
    }
}