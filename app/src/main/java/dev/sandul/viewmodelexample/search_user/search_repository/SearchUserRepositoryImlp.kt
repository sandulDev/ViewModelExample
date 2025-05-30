package dev.sandul.viewmodelexample.search_user.search_repository

import dev.sandul.viewmodelexample.data.UserDataSource
import dev.sandul.viewmodelexample.search_user.search_viewmodel.User

class SearchUserRepositoryImlp(
    private val dataSource: UserDataSource
) : SearchUserRepository {

    override suspend fun searchUsers(query: String): List<User> {
        return dataSource.searchUser(query)
    }

    override suspend fun insertUsers(users: List<User>) {
        dataSource.insertUsers(users = users)
    }
}