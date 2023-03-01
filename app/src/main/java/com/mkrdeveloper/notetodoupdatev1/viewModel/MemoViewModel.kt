package com.mkrdeveloper.notetodoupdatev1.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mkrdeveloper.notetodoupdatev1.data.MemoDatabase
import com.mkrdeveloper.notetodoupdatev1.repository.MemoRepository
import com.mkrdeveloper.notetodoupdatev1.models.Memo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemoViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Memo>>

    val repository: MemoRepository

    init{
        val memoDao = MemoDatabase.getDatabase(application).memoDao()

        repository = MemoRepository(memoDao)
        readAllData = repository.readAllData
    }

    fun addMemo(memo: Memo){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMemo(memo)
        }
    }
}