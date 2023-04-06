package com.example.myexpensemanager.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.example.myexpensemanager.ModelClass.CategoryModelClass
import com.example.myexpensemanager.R

class CategoryAdapter(var listTypes: ArrayList<CategoryModelClass>, var n: ((String) -> Unit)) :
    RecyclerView.Adapter<CategoryAdapter.MyAdapter>() {
    var pos = -1

    class MyAdapter(view: View) : RecyclerView.ViewHolder(view) {
        var rbCategory: RadioButton = view.findViewById(R.id.rbCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter {
        var v =
            LayoutInflater.from(parent.context).inflate(R.layout.category_item_list, parent, false)

        return MyAdapter(v)
    }

    override fun onBindViewHolder(holder: MyAdapter, position: Int) {
        holder.rbCategory.setText(listTypes[position].categoryname)
        holder.rbCategory.setOnClickListener {
            n.invoke(listTypes[position].categoryname)
            pos = position
            notifyDataSetChanged()
        }
        holder.rbCategory.isChecked = position == pos
    }

    override fun getItemCount(): Int {
        return listTypes.size
    }


}