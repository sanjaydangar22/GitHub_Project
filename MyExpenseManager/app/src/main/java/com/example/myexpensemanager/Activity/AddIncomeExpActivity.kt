package com.example.myexpensemanager.Activity

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myexpensemanager.Adapter.CategoryAdapter
import com.example.myexpensemanager.CategoryHelper
import com.example.myexpensemanager.Adapter.ModeAdapter
import com.example.myexpensemanager.ModelClass.CategoryModelClass
import com.example.myexpensemanager.databinding.ActivityAddIncomeBinding
import com.example.myexpensemanager.databinding.DialogCategoryBinding
import com.example.myexpensemanager.databinding.DialogModeBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class AddIncomeExpActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddIncomeBinding

    var listTypes = ArrayList<CategoryModelClass>()

    lateinit var dbS: CategoryHelper
    var mode = ArrayList<String>()

    var selectedcategory = ""
    var selectedMode = ""
    var dateValue = ""
    var type = -1
    var name = String
    var id_number = 0
    var flag = 0

    var page: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddIncomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var name: String? = intent.getStringExtra("title")
        binding.txtTitle.text = name
        dbS = CategoryHelper(this)



        initview()
    }


    private fun initview() {
//        page= intent.getStringExtra("page")
//        when(page){
//            "Income"->
//                binding.rbIncome.isChecked=true
//
//            "Expense"->
//                binding.rbExpense.isChecked=true
//
//        }
        if (intent != null && intent.hasExtra("updateRecord")) {

            flag = 1
            var newAmt: String? = intent.getStringExtra("amount")
            var newNote: String? = intent.getStringExtra("note")
            var icon: String? = intent.getStringExtra("key_icon")
            id_number = intent.getIntExtra("id", 0)
            binding.txtDone.text = icon
            binding.edtAmount.setText(newAmt)
            binding.edtNote.setText(newNote)
        }



        binding.txtDone.setOnClickListener {
            var amount = binding.edtAmount.text.toString()
            var notes = binding.edtNote.text.toString()

            if (amount.isEmpty()) {
                Toast.makeText(this, "please enter amount", Toast.LENGTH_SHORT).show()
            } else if (amount.length <= 1 || amount.length >= 10) {
                Toast.makeText(this, "please enter a amount", Toast.LENGTH_SHORT).show()
            } else if (notes.isEmpty()) {
                Toast.makeText(this, "please enter a Note", Toast.LENGTH_SHORT).show()
            } else if (notes.length <= 1 || notes.length >= 10) {
                Toast.makeText(this, "please enter a Note", Toast.LENGTH_SHORT).show()
            } else if (notes.isEmpty()) {
                Toast.makeText(this, "please enter a Note", Toast.LENGTH_SHORT).show()
            } else if (notes.length <= 1 || notes.length >= 20) {
                Toast.makeText(this, "please enter a Note", Toast.LENGTH_SHORT).show()
            } else {

                if (binding.rdgType.checkedRadioButtonId == -1) {

                } else {
                    val selectId: Int = binding.rdgType.checkedRadioButtonId
                    var selectedRadioButton: RadioButton = findViewById(selectId)
                    var text = selectedRadioButton.text.toString()

                    if (text.equals("Income")) {
                        type = 1
                    } else {
                        type = 2
                    }
                    Log.e("TAG", "button: " + binding.txtDone.text.toString())
                    if (flag==1) {
                        dbS.updateRecord(amount, notes, id_number)
                        Log.e("TAG", "Amount " + amount + "")

                    } else {
                        dbS.insertExpenseIncomeRecord(
                            dateValue,
                            amount,
                            selectedcategory,
                            selectedMode,
                            type,
                            notes
                        )
                        Log.e("TAG", "Date: " + dateValue)
                    }

                }
            }

            val trans = Intent(this@AddIncomeExpActivity, TransactionActivity::class.java)
            startActivity(trans)


        }
        val simlpeDateFormat = SimpleDateFormat("dd/MM/yyyy")
        val date: String = simlpeDateFormat.format(Date())
        binding.txtDate.text = date

        dateValue = date

        val simlpeTimeFormat = SimpleDateFormat("hh : mm")
        val time: String = simlpeTimeFormat.format(Date())
        binding.txtTime.text = time



        binding.imgBack.setOnClickListener {
            val b = Intent(this@AddIncomeExpActivity, HomePageActivity::class.java)
            startActivity(b)
            finish()
        }

        binding.loutCategory.setOnClickListener {
            val dialog = Dialog(this)
            val dialogBinding = DialogCategoryBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)

            listTypes = dbS.displayRecord()


            var adapter = CategoryAdapter(listTypes) { categoryname ->
                Log.e("TAG", "category : " + categoryname)
                selectedcategory = categoryname
                binding.txtSelectedCategory.text = categoryname
            }

            var manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            dialogBinding.rcvCategory.layoutManager = manager
            dialogBinding.rcvCategory.adapter = adapter

            dialogBinding.btnCategoryCancel.setOnClickListener {
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            dialogBinding.btnCategorySelect.setOnClickListener {
                Toast.makeText(this, "DONE", Toast.LENGTH_SHORT).show()
                dialog.dismiss()

            }

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            dialog.show()
        }
        binding.loutMode.setOnClickListener {
            val dialogMode = Dialog(this)
            val modeBinding = DialogModeBinding.inflate(layoutInflater)
            dialogMode.setContentView(modeBinding.root)

            modeBinding.btnModeSelect.setOnClickListener {
                Toast.makeText(this, "DONE", Toast.LENGTH_SHORT).show()
                dialogMode.dismiss()
            }

            modeBinding.btnModeCancel.setOnClickListener {
                dialogMode.dismiss()
            }
            dialogMode.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialogMode.window?.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            dialogMode.show()

            var adapter = ModeAdapter(mode) { mode ->
                selectedMode = mode
                binding.txtSelectedMode.text = mode
                Log.e("TAG", "payment: " + mode)
            }
            var modeManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            modeBinding.rcvMode.layoutManager = modeManager
            modeBinding.rcvMode.adapter = adapter
        }

        mode.add("CASH")
        mode.add("CREDIT CARD")
        mode.add("DEBIT CARD")
        mode.add("UPI")
        mode.add("NET BANKING")
        mode.add("CHEQUE")


    }


}