package com.mkrdeveloper.notetodoupdatev1.repository

import androidx.lifecycle.LiveData
import com.mkrdeveloper.notetodoupdatev1.data.MemoDao
import com.mkrdeveloper.notetodoupdatev1.models.Memo

class MemoRepository(private val memoDao: MemoDao) {

    val readAllData: LiveData<List<Memo>> = memoDao.readAllData()

    suspend fun addMemo(memo: Memo){
        memoDao.addMemo(memo)

    }
}