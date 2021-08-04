package com.xvadsan.blankmvvm.data

import com.xvadsan.blankmvvm.data.database.DbModel
import kotlinx.coroutines.flow.Flow

interface DatabaseSource {

    fun getValue(id: Long): Flow<DbModel>

    suspend fun insertValue(dbModel: DbModel)
}
