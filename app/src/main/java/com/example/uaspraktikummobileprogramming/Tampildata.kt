package com.example.uaspraktikummobileprogramming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uaspraktikummobileprogramming.sql.Data
import com.example.uaspraktikummobileprogramming.sql.dataDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.log

class Tampildata : AppCompatActivity() {

    val db by lazy { dataDB( this ) }
    lateinit var tampildataAdapter: tampildata_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tampildata)

        listdata()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val data = db.Crud().getdata()
            Log.d("Tampildata", "respon:$data")
            withContext(Dispatchers.Main){
                tampildataAdapter.setdata( data )
            }
        }
    }

    fun listdata(){
        val listData:RecyclerView = findViewById(R.id.listData)

        tampildataAdapter = tampildata_Adapter(arrayListOf())
        listData.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = tampildataAdapter
        }
    }
}