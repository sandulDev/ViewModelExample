package dev.sandul.viewmodelexample.search_user.search_repository

import dev.sandul.viewmodelexample.search_user.search_viewmodel.User
import kotlinx.coroutines.delay

class SearchUserRepositoryImlp : SearchUserRepository {
    private val users = listOf(
        User(1, "Oleksandr"),
        User(7, "Oleksandr"),
        User(2, "Ivan"),
        User(3, "Anna"),
        User(4, "Dmytro"),
        User(5, "Alex"),
        User(6, "Tetiana")
    )

    override suspend fun searchUsers(query: String): List<User> {
        delay(1500)
        return if (query.isBlank()) emptyList()
        else users.filter { user -> user.name.contains(query, ignoreCase = true) }
    }
}