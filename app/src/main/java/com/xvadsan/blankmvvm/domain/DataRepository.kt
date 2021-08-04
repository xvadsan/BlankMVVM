package com.xvadsan.blankmvvm.domain

import com.xvadsan.blankmvvm.data.database.DbModel
import kotlinx.coroutines.flow.Flow

interface DataRepository {

    fun getValue(id: Long): Flow<DbModel>

   suspend fun insertValue(dbModel: DbModel)
}