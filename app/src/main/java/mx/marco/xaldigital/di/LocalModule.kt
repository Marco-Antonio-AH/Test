package mx.marco.xaldigital.di

//import android.app.Application
//import androidx.room.Room
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import mx.marco.xaldigital.data.local.RecordDatabase
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object LocalModule {
//
//    @Provides
//    @Singleton
//    fun provideRecordDatabase(
//        app: Application
//    ): RecordDatabase {
//        return Room.databaseBuilder(
//            app,
//            RecordDatabase::class.java,
//            "record_database"
//        )
//            .fallbackToDestructiveMigration()
//            .build()
//    }
//
//}