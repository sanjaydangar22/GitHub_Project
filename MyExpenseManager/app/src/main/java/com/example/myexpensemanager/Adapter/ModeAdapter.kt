package com.example.myexpensemanager.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.example.myexpensemanager.R

class ModeAdapter(var modeList: ArrayList<String>, var invo: ((String) -> Unit)) :
    RecyclerView.Adapter<ModeAdapter.MyViewHolder>() {
    var pos = -1

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var rbMode: RadioButton = view.findViewById(R.id.rbMode)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.mode_item_list, parent, false)

        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.rbMode.text = modeList[position]
        holder.rbMode.setOnClickListener {
            invo.invoke(modeList[position])
            pos = position
            notifyDataSetChanged()
        }
        holder.rbMode.isChecked = position == pos
    }

    override fun getItemCount(): Int {
        return modeList.size
    }
}