package com.forestguard.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val email: String,
    val password: String,
    val name: String,
    val role: String = "Guardián del Bosque",
    val level: Int = 1,
    val xp: Int = 0
)
