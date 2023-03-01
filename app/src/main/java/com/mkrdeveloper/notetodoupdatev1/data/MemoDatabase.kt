package com.mkrdeveloper.notetodoupdatev1.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mkrdeveloper.notetodoupdatev1.models.Memo


@Database(entities = [Memo::class], version = 1, exportSchema = false)
abstract class MemoDatabase: RoomDatabase(){

    abstract fun memoDao(): MemoDao

    companion object{
        @Volatile
        private var INSTANCE : MemoDatabase? = null

        fun getDatabase(context : Context): MemoDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MemoDatabase::class.java,
                    "memo_table"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}