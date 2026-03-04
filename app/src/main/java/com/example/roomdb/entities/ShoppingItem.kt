package com.example.roomdb.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val name: String, // column names
    val price: Double,
    val quantity: Int,
    val isBought: Boolean = false
)
