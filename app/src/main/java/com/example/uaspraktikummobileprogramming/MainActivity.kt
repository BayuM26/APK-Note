package com.example.uaspraktikummobileprogramming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.uaspraktikummobileprogramming.sql.Data
import com.example.uaspraktikummobileprogramming.sql.dataDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val db by lazy { dataDB( this ) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tampildata()
        saveData()
    }

    fun saveData(){
        val btn_simpan:Button = findViewById(R.id.btn_simpan)
        val isidata:EditText = findViewById(R.id.et_data)

        btn_simpan.setOnClickListener(){
            CoroutineScope(Dispatchers.IO).launch {
                db.Crud().tambahData(
                    Data(
                        0,
                        isidata.text.toString()
                    )
                )
            }
            Toast.makeText(this, "DATA BERHASIL DI SIMPAN", Toast.LENGTH_SHORT).show()
        }
    }

    fun tampildata(){
        val btn_tampildata:Button = findViewById(R.id.btn_tampildata)
        btn_tampildata.setOnClickListener{
            startActivity(Intent(this,Tampildata::class.java))
            Toast.makeText(this, "MEMBUKA TAMPIL DATA", Toast.LENGTH_SHORT).show()
        }
    }
}