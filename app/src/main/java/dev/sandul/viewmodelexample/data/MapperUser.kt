package dev.sandul.viewmodelexample.data

import dev.sandul.viewmodelexample.search_user.search_viewmodel.User


fun UserEntity.toDomain(): User = User(id, name)
fun User.toEntity(): UserEntity = UserEntity(id, name)