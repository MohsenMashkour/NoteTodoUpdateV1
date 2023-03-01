package com.mkrdeveloper.notetodoupdatev1.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.w3c.dom.Text

@Entity(tableName = "memo_table")
data class Memo(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val memoTitle : String,
    val memoBody : String
)
