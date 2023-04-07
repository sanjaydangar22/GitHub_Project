package com.example.myexpensemanger.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myexpensemanger.R
import com.example.myexpensemanger.activity.AddScreenActivty
import com.example.myexpensemanger.modelclass.IncomeExpenseModelClass

class TransactionAdapter(
    var context: Context,
    var listTransaction: ArrayList<IncomeExpenseModelClass>,
    var edit: (IncomeExpenseModelClass) -> Unit,
    var delete: (Int) -> Unit
) : RecyclerView.Adapter<TransactionAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var id: TextView = itemView.findViewById(R.id.txtIdTra)
        var amount: TextView = itemView.findViewById(R.id.txtAmountTra)
        var categoryName: TextView = itemView.findViewById(R.id.txtCategoryTra)
        var date: TextView = itemView.findViewById(R.id.txtDateTra)
        var mode: TextView = itemView.findViewById(R.id.txtModeSelectedTra)
        var note: TextView = itemView.findViewById(R.id.txtNoteTra)
        var type: TextView = itemView.findViewById(R.id.txtTypeTra)

        var edit: ImageView = itemView.findViewById(R.id.imgEdit)
        var delete: ImageView = itemView.findViewById(R.id.imgDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.transaction_data_list, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listTransaction.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.id.text = listTransaction[position].id.toString()
        holder.amount.text = listTransaction[position].amount
        holder.categoryName.text = listTransaction[position].selectedCategory
        holder.date.text = listTransaction[position].date
        holder.mode.text = listTransaction[position].mode
        holder.note.text = listTransaction[position].note
        holder.type.text = listTransaction[position].page

        holder.edit.setOnClickListener {
            edit.invoke(listTransaction[position])

        }
        holder.delete.setOnClickListener {

            delete.invoke(listTransaction[position].id)



        }


    }

    fun updateData(listTransaction: ArrayList<IncomeExpenseModelClass>) {
        this.listTransaction = ArrayList()
        this.listTransaction.addAll(listTransaction)
        notifyDataSetChanged()
    }




}