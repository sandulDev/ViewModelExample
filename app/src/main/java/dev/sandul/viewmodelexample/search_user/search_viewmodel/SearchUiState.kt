package dev.sandul.viewmodelexample.search_user.search_viewmodel

data class SearchUiState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String? = null
)
