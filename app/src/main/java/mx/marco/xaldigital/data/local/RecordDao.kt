package mx.marco.xaldigital.data.local



import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import mx.marco.xaldigital.data.local.entity.ProbabilityEntity
import mx.marco.xaldigital.data.local.entity.RecordEntity
import mx.marco.xaldigital.data.local.entity.RecordWithProbability

@Dao
interface RecordDao {

    @Insert//(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecord(recordEntity: RecordEntity): Long

    @Insert//(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProbability(probabilityEntity: ProbabilityEntity)

    @Transaction
    @Query("SELECT * FROM record")
    suspend fun getUserWithPosts(): List<RecordWithProbability>

}