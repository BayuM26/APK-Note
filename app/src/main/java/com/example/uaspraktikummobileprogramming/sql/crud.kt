package com.example.uaspraktikummobileprogramming.sql

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface crud {
    @Insert
    fun tambahData(data :Data)

    @Query("SELECT * FROM data")
    fun getdata():List<Data>
}