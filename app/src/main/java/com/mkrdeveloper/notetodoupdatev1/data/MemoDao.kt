package com.mkrdeveloper.notetodoupdatev1.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mkrdeveloper.notetodoupdatev1.models.Memo

@Dao
interface MemoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMemo(memo: Memo)

    @Query("SELECT * FROM memo_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Memo>>
}