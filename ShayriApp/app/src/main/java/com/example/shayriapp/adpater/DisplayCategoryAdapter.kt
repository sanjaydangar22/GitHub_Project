package com.example.shayriapp.adpater

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.example.shayriapp.R
import com.example.shayriapp.modeclass.DisplayCategoryModelClass


class DisplayCategoryAdapter(
    var context: Context,            //  context class set using  parameter
    var click: (DisplayCategoryModelClass) -> Unit,     // set invoke
    var like: (Int, Int) -> Unit                  // set invoke
) : RecyclerView.Adapter<DisplayCategoryAdapter.MyViewHolder>() {

    var shariList= ArrayList<DisplayCategoryModelClass>()  //Array list in model class set using  parameter

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ShariItem: TextView = itemView.findViewById(R.id.txtShari)  //id binding
        var imgLikeD: ImageView = itemView.findViewById(R.id.imgLikeD)   //id binding
        var imgShareD: ImageView = itemView.findViewById(R.id.imgShareD)   //id binding
        var imgCopyD: ImageView = itemView.findViewById(R.id.imgCopyD)   //id binding
        var layout: LinearLayout = itemView.findViewById(R.id.layout)   //id binding

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(parent.context)
            .inflate(R.layout.display_category_data, parent, false)  // set xml file
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return shariList.size  //set array list size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.ShariItem.text =
            shariList[position].shayri_item   //set model class variable in text view

        //copy  text
        holder.imgCopyD.setOnClickListener {               // set on click listener
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip: ClipData = ClipData.newPlainText("simple text", "Hello, World!")
            clipboard.setPrimaryClip(clip)
            Toast.makeText(context, "Copy", Toast.LENGTH_SHORT).show()
        }

        //Shear text
        holder.imgShareD.setOnClickListener(View.OnClickListener { s: View? ->
            val ShareIntent = Intent(Intent.ACTION_SEND)
            ShareIntent.type = "text/plain"
            ShareIntent.putExtra(Intent.EXTRA_TEXT, shariList[position].shayri_item)
            context.startActivity(ShareIntent)
        })

//click page
        holder.layout.setOnClickListener {
            click.invoke(shariList[position])
        }

        //like
        if (shariList[position].fav == 1) {
            holder.imgLikeD.setImageResource(R.drawable.heartcolor)

        } else {
            holder.imgLikeD.setImageResource(R.drawable.heartwhite)
        }

//like
        holder.imgLikeD.setOnClickListener {

            if (shariList[position].fav == 1) {

                like.invoke(0,shariList[position].shayri_id)
                holder.imgLikeD.setImageResource(R.drawable.heartwhite)
                shariList[position].fav = 0
                Log.e("TAG", "Display: " + shariList[position].fav)
            } else {

                like.invoke(1,shariList[position].shayri_id)
                holder.imgLikeD.setImageResource(R.drawable.heartcolor)

                shariList[position].fav = 1

            }

        }

    }

    fun updateList(shariList: ArrayList<DisplayCategoryModelClass>) {
       this.shariList=ArrayList()
        this.shariList.addAll(shariList)
        notifyDataSetChanged()
    }

}