package com.xvadsan.blankmvvm.di

import android.content.Context
import androidx.room.Room
import com.xvadsan.blankmvvm.data.*
import com.xvadsan.blankmvvm.data.database.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class DataSource

    @Singleton
    @DataSource
    @Provides
    fun provideDataSource(
        database: Database
    ): DatabaseSource {
        return DatabaseDataSource(
            database.dao()
        )
    }

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(
            context.applicationContext,
            Database::class.java,
            "Database.db"
        ).build()
    }
}
