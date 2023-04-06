package com.example.myexpensemanager.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myexpensemanager.ModelClass.IncomeExpenseModelClass
import com.example.myexpensemanager.R

class TransactionAdapter(
    var incomeExpenselist: ArrayList<IncomeExpenseModelClass>,
    var invo: ((IncomeExpenseModelClass) -> Unit),
    var delete: ((Int) -> Unit)
) : RecyclerView.Adapter<TransactionAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        var txtDate: TextView = view.findViewById(R.id.txtDate)
        var txtAmount: TextView = view.findViewById(R.id.txtAmount)
        var txtNote: TextView = view.findViewById(R.id.txtNote)
        var txtCategoryType: TextView = view.findViewById(R.id.txtCategoryType)
        var txtMode: TextView = view.findViewById(R.id.txtMode)
        var imgEdit: ImageView = view.findViewById(R.id.imgEdit)
        var imgDelete: ImageView = view.findViewById(R.id.imgDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.transaction_recycler_item, parent, false)
        var view = MyViewHolder(v)
        return view
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtDate.text = incomeExpenselist[position].date
        holder.txtAmount.text = incomeExpenselist[position].amount
        holder.txtCategoryType.text = incomeExpenselist[position].category
        holder.txtMode.text = incomeExpenselist[position].mode




        holder.txtNote.text = incomeExpenselist[position].note
        holder.imgEdit.setOnClickListener {
            invo.invoke(incomeExpenselist[position])
        }
        holder.imgDelete.setOnClickListener {
            delete.invoke(incomeExpenselist[position].id)
            Log.e("TAG", "delete ")
        }
    }

    override fun getItemCount(): Int {
        return incomeExpenselist.size
    }

    fun updatedData(incomeExpenselist: ArrayList<IncomeExpenseModelClass>) {
        this.incomeExpenselist = ArrayList()
        this.incomeExpenselist.addAll(incomeExpenselist)
        notifyDataSetChanged()
    }


}