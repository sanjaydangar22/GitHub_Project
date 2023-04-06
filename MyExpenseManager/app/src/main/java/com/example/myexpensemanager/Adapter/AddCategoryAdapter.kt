package com.example.myexpensemanager.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myexpensemanager.ModelClass.CategoryModelClass
import com.example.myexpensemanager.R

class AddCategoryAdapter() : RecyclerView.Adapter<AddCategoryAdapter.MyViewHolder>() {
    var list = ArrayList<CategoryModelClass>()

    class MyViewHolder(vi: View) : RecyclerView.ViewHolder(vi) {
        var txtView: TextView = vi.findViewById(R.id.txtCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.rcv_category_add_item, parent, false)

        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtView.text = list[position].categoryname
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateData(list: ArrayList<CategoryModelClass>) {
        this.list = list
        notifyDataSetChanged()
    }


}