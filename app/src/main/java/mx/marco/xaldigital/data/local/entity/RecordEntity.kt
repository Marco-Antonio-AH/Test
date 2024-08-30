package mx.marco.xaldigital.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "record")
data class RecordEntity (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "record_id") val recordId: Long = 0,
    @ColumnInfo(name = "record_name") val name: String
)





