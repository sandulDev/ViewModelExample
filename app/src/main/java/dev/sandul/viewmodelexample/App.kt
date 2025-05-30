package dev.sandul.viewmodelexample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import dev.sandul.viewmodelexample.data.AppDatabase
import dev.sandul.viewmodelexample.data.UserDataSource
import dev.sandul.viewmodelexample.search_user.search_repository.SearchUserRepositoryImlp
import dev.sandul.viewmodelexample.search_user.search_viewmodel.SearchViewModel
import dev.sandul.viewmodelexample.search_user.search_viewmodel.User
import dev.sandul.viewmodelexample.search_user.ui.SearchScreen

@Composable
fun App() {
    val context = LocalContext.current
    val db = remember { AppDatabase.getInstance(context) }
    val userDao = db.userDao()
    val dataSource = remember { UserDataSource(userDao) }
    val viewModel = remember { SearchViewModel(SearchUserRepositoryImlp(dataSource)) }
    LaunchedEffect(Unit) {
        viewModel.insertUsers(
            listOf(
                User(1, "Oleksandr"),
                User(7, "Oleksandr"),
                User(2, "Ivan"),
                User(3, "Anna"),
                User(4, "Dmytro"),
                User(5, "Alex"),
                User(6, "Tetiana")
            )
        )
    }




    SearchScreen(viewModel)
}