package dev.sandul.viewmodelexample.search_user.search_repository

import dev.sandul.viewmodelexample.search_user.search_viewmodel.User

interface SearchUserRepository {
    suspend fun searchUsers(query: String): List<User>
}