package com.example.myexpensemanager.Activity

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myexpensemanager.CategoryHelper
import com.example.myexpensemanager.ModelClass.IncomeExpenseModelClass
import com.example.myexpensemanager.Adapter.TransactionAdapter
import com.example.myexpensemanager.databinding.ActivityTransactionBinding
import com.example.myexpensemanager.databinding.DialogDeleteBinding

class TransactionActivity : AppCompatActivity() {

    lateinit var transactionBinding: ActivityTransactionBinding

    lateinit var dbT: CategoryHelper

    lateinit var adapter: TransactionAdapter
    var incomeExpenselist = ArrayList<IncomeExpenseModelClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        transactionBinding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(transactionBinding.root)

        dbT = CategoryHelper(this)
        intview()
    }

    private fun intview() {

        incomeExpenselist = dbT.displayIncomeExpenseRecord()
        adapter = TransactionAdapter(incomeExpenselist, {
            var titleUpdate = "Update Data"
            var iconUpdate = "update"
            val transaction = Intent(this@TransactionActivity, AddIncomeExpActivity::class.java)
            transaction.putExtra("id", +it.id)
            transaction.putExtra("type", it.type)
            transaction.putExtra("amount", it.amount)
            transaction.putExtra("note", it.note)
            transaction.putExtra("title", titleUpdate)
            transaction.putExtra("key_icon", iconUpdate)
            transaction.putExtra("updateRecord", true)
            startActivity(transaction)
            finish()
        }) {
            val dialog = Dialog(this)
            val dialogDelete = DialogDeleteBinding.inflate(layoutInflater)
            dialog.setContentView(dialogDelete.root)



            dialogDelete.btnDeleteCancel.setOnClickListener {
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            dialogDelete.btnDeleteSelect.setOnClickListener {

                incomeExpenselist = dbT.displayIncomeExpenseRecord()
                adapter.updatedData(incomeExpenselist)
                Toast.makeText(this, "DELETED", Toast.LENGTH_SHORT).show()
                dialog.dismiss()

            }
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            dialog.show()

            dbT.deleteRecord(it)

        }


        var manger = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        transactionBinding.rcvTransaction.layoutManager = manger
        transactionBinding.rcvTransaction.adapter = adapter

        incomeExpenselist = dbT.displayIncomeExpenseRecord()
        adapter.updatedData(incomeExpenselist)

        transactionBinding.imgDoneTransaction.setOnClickListener {
            val transaction = Intent(this@TransactionActivity, HomePageActivity::class.java)
            startActivity(transaction)
        }

        transactionBinding.imgBackTransaction.setOnClickListener {
            val transaction = Intent(this@TransactionActivity, HomePageActivity::class.java)
            startActivity(transaction)
        }
    }
}