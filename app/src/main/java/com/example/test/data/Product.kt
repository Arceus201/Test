package com.example.test.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class Product(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var firstName: String ="",
    var lastName: String = "",
    var position: String =""
)
