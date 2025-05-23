package dev.sandul.viewmodelexample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.sandul.viewmodelexample.search_user.search_repository.SearchUserRepositoryImlp
import dev.sandul.viewmodelexample.search_user.search_viewmodel.SearchViewModel
import dev.sandul.viewmodelexample.search_user.ui.SearchScreen

@Composable
fun App() {
    val viewModel = remember { SearchViewModel(SearchUserRepositoryImlp()) }
    SearchScreen(viewModel)
}