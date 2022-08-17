package com.nicomahnic.heladerakt.di

import android.content.Context
import androidx.room.Room
import com.nicomahnic.heladerakt.data.datasource.database.AppDatabase
import com.nicomahnic.heladerakt.data.datasource.database.dao.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideIceCreamOptionsDAO(appDatabase: AppDatabase): IceCreamOptionsDao {
        return appDatabase.iceCreamOptionsDao()
    }

    @Singleton
    @Provides
    fun provideOrdersDAO(appDatabase: AppDatabase): OrdersDao {
        return appDatabase.orderDao()
    }

    @Singleton
    @Provides
    fun provideUsersDAO(appDatabase: AppDatabase): UsersDao {
        return appDatabase.usersDao()
    }

    @Singleton
    @Provides
    fun provideDeliveriesDAO(appDatabase: AppDatabase): DeliveriesDao {
        return appDatabase.deliveriesDao()
    }

    @Singleton
    @Provides
    fun provideTastesDAO(appDatabase: AppDatabase): TastesDao {
        return appDatabase.tastesDao()
    }

    @Singleton
    @Provides
    fun provideTasteOptionsDAO(appDatabase: AppDatabase): TasteOptionsDao {
        return appDatabase.tasteOptionsDao()
    }


}