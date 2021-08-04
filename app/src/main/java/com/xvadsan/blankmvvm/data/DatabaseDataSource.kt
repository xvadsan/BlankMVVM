package com.xvadsan.blankmvvm.data

import com.xvadsan.blankmvvm.data.database.DbDao
import com.xvadsan.blankmvvm.data.database.DbModel
import kotlinx.coroutines.flow.Flow

class DatabaseDataSource internal constructor(
    private val dbDao: DbDao
) : DatabaseSource {

    override fun getValue(id: Long): Flow<DbModel> {
        return dbDao.getValue(id)
    }

    override suspend fun insertValue(dbModel: DbModel) {
        dbDao.insertValue(dbModel)
    }
}
