package mx.marco.xaldigital.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mx.marco.xaldigital.data.local.entity.ProbabilityEntity
import mx.marco.xaldigital.data.local.entity.RecordEntity
import mx.marco.xaldigital.data.local.entity.RecordWithProbability
import mx.marco.xaldigital.domain.model.network.response.CountryResponse
import mx.marco.xaldigital.domain.model.network.response.UserResponse


@Database(entities = [RecordEntity::class, ProbabilityEntity::class], version = 1)
abstract class RecordDatabase : RoomDatabase() {
    abstract fun recordDao(): RecordDao

    companion object {
        @Volatile
        private var INSTANCE: RecordDatabase? = null

        fun getInstance(context: Context): RecordDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecordDatabase::class.java,
                    "record_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}





fun insertRecord(context: Context, resultData: UserResponse) {
    val database = RecordDatabase.getInstance(context)
    val recordDao = database.recordDao()
    val record = RecordEntity(name = resultData.name!!)
    CoroutineScope(Dispatchers.IO).launch {
        val recordId = recordDao.insertRecord(record)
        resultData.country.forEach { country ->
            recordDao.insertProbability(
                countryResponseToProbabilityEntity(
                    recordId = recordId,
                    countryResponse = country
                )
            )
        }
    }
}

fun viewData(context: Context): List<RecordWithProbability> {
    val database = RecordDatabase.getInstance(context)
    val recordDao = database.recordDao()

    val allUsersWithPosts: ArrayList<RecordWithProbability> = arrayListOf()
    runBlocking {
        recordDao.getUserWithPosts().forEach {
            allUsersWithPosts.add(it)
        }
    }
    return allUsersWithPosts
}


fun countryResponseToProbabilityEntity(
    recordId: Long,
    countryResponse: CountryResponse
): ProbabilityEntity {
    return ProbabilityEntity(
        probability = countryResponse.probability!!,
        countryId = countryResponse.countryId!!,
        userDataId = recordId

    )
}