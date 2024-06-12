package com.example.coroutinekotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.coroutinekotlin.databinding.LayoutItemBinding
import com.example.coroutinekotlin.model.Result

class DataAdapterList(private val mList : List<Result>) : RecyclerView.Adapter<DataAdapterList.DataViewHolder>() {


    class DataViewHolder(val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {

      return DataViewHolder(LayoutItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
      return mList.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
      holder.binding.text1.text = mList[position].author
        holder.binding.text2.text = mList[position].content

    }
}