package mx.marco.xaldigital.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mx.marco.xaldigital.data.remote.XalDigitalApiService
import mx.marco.xaldigital.data.repository.UserRepositoryImpl
import mx.marco.xaldigital.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideEventRepository(
        api: XalDigitalApiService
        ): UserRepository {
        return UserRepositoryImpl(api)
    }

//    @Provides
//    @Singleton
//    fun provideLocalRepository(
//        database: RecordDatabase
//    ): LocalRepository {
//        return LocalRepositoryImpl(
//            database.recordDao()
//        )
//    }
}