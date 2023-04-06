package com.example.myexpensemanager.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myexpensemanager.databinding.ActivityHomePageBinding


class HomePageActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {

        var titleIncome = "Add Income"
        binding.cdIncome.setOnClickListener {
            var income = Intent(this@HomePageActivity, AddIncomeExpActivity::class.java)
            income.putExtra("title", titleIncome)
            income.putExtra("page", " Income")
            startActivity(income)
        }

        var titleExpense = "Add Expense"
        binding.cdExpenses.setOnClickListener {
            var expense = Intent(this@HomePageActivity, AddIncomeExpActivity::class.java)
            expense.putExtra("title", titleExpense)
            expense.putExtra("page", " Expense")
            startActivity(expense)
        }

        binding.cdTransaction.setOnClickListener {
            val k = Intent(this@HomePageActivity, TransactionActivity::class.java)
            startActivity(k)
        }

        binding.cdReports.setOnClickListener {
            val l = Intent(this@HomePageActivity, ReportsActivity::class.java)
            startActivity(l)
        }

        binding.cdCategory.setOnClickListener {
            val m = Intent(this@HomePageActivity, AddCategoryAcitivity::class.java)
            startActivity(m)
        }

    }
}

