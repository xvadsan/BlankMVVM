package com.xvadsan.blankmvvm.di

import com.xvadsan.blankmvvm.domain.DataRepository
import com.xvadsan.blankmvvm.domain.DataRepositoryImpl
import com.xvadsan.blankmvvm.data.DatabaseSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

object DatabaseModule {

    @Module
    @InstallIn(SingletonComponent::class)
    object DatabaseRepositoryModule {

        @Singleton
        @Provides
        fun provideDatabaseRepository(
            @AppModule.DataSource dataSource: DatabaseSource
        ): DataRepository {
            return DataRepositoryImpl(
                dataSource
            )
        }
    }

}