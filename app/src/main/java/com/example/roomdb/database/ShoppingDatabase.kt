package com.example.roomdb.database

import android.R.attr.version
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdb.dao.ShoppingItemDAO
import com.example.roomdb.entities.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDatabase : RoomDatabase() {
    abstract fun shoppingItemDao(): ShoppingItemDAO
}