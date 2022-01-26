package com.example.uaspraktikummobileprogramming.sql

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(
    entities = [Data::class],
    version = 1
)
abstract class dataDB : RoomDatabase(){
    abstract fun Crud() : crud

    companion object{

        @Volatile private var instance : dataDB? = null
        private  val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            dataDB::class.java,
            "UASDB"
        ).build()
    }
}