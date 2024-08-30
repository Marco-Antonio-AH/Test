package mx.marco.xaldigital.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation



data class RecordWithProbability(
    @Embedded val record: RecordEntity,
    @Relation(
        parentColumn = "record_id",
        entityColumn = "user_data_id"
    )
    val probabilities: List<ProbabilityEntity>
)