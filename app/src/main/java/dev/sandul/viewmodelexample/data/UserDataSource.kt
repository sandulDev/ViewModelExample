package dev.sandul.viewmodelexample.data

import dev.sandul.viewmodelexample.search_user.search_viewmodel.User

class UserDataSource(private val userDao: UserDao) {
    suspend fun searchUser(query: String): List<User> {
        return userDao.searchUser(query).map { it.toDomain() }
    }

    suspend fun insertUsers(users: List<User>) {
        userDao.insertAll(users.map { it.toEntity() })
    }
}