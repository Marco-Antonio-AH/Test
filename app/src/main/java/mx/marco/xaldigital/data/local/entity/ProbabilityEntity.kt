package mx.marco.xaldigital.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    foreignKeys = [ForeignKey(
        entity = RecordEntity::class,
        parentColumns = ["record_id"], // Coincide con @ColumnInfo en RecordEntity
        childColumns = ["user_data_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ProbabilityEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "probability_id") val probabilityId: Int = 0,
    @ColumnInfo(name = "probability_value") val probability: Double,
    @ColumnInfo(name = "country_id") val countryId: String,
    @ColumnInfo(name = "user_data_id") val userDataId: Long
)
