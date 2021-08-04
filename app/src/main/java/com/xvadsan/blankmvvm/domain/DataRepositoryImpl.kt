package com.xvadsan.blankmvvm.domain

import com.xvadsan.blankmvvm.data.DatabaseSource
import com.xvadsan.blankmvvm.data.database.DbModel
import kotlinx.coroutines.flow.Flow

class DataRepositoryImpl internal constructor(
    private val dataSource: DatabaseSource
) : DataRepository {

    override fun getValue(id: Long): Flow<DbModel> {
        return dataSource.getValue(id)
    }

    override suspend fun insertValue(dbModel: DbModel) {
        dataSource.insertValue(dbModel)
    }
}