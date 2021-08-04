package com.xvadsan.blankmvvm.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DbDao {

    @Query("SELECT * FROM DB_EXAMPLE WHERE Id = :id")
    fun getValue(id: Long): Flow<DbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertValue(dbModel: DbModel)
}
