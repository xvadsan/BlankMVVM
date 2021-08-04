package com.xvadsan.blankmvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [DbModel::class],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {

    abstract fun dao(): DbDao
}
