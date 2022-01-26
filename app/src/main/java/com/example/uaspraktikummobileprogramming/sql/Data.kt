package com.example.uaspraktikummobileprogramming.sql

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Data (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val isi_data: String
        )


