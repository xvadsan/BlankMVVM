package com.xvadsan.blankmvvm.data.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "DB_EXAMPLE")
class DbModel(

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "Id")
    var id: Long,

    @NonNull
    @ColumnInfo(name = "Name")
    var name: String

)
