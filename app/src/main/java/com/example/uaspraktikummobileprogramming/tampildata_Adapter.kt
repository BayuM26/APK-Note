package com.example.uaspraktikummobileprogramming

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uaspraktikummobileprogramming.sql.Data
import kotlinx.android.synthetic.main.tampildata_adapter.view.*

class tampildata_Adapter (private val datas: ArrayList<Data>): RecyclerView.Adapter<tampildata_Adapter.DataViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.tampildata_adapter, parent, false)
        )
    }


    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = datas[position]
        holder.view.TV_adapter_tampil.text = data.isi_data
    }


    override fun getItemCount() = datas.size

   class DataViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setdata(list: List<Data>){
        datas.clear()
        datas.addAll(list)
        notifyDataSetChanged()
    }
}