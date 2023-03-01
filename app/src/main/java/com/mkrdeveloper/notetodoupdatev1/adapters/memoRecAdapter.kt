package com.mkrdeveloper.notetodoupdatev1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.mkrdeveloper.notetodoupdatev1.R
import com.mkrdeveloper.notetodoupdatev1.models.Memo

 class memoRecAdapter(private val memoList: List<Memo>) : RecyclerView.Adapter<memoRecAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.memo_item, parent,false)
         return ViewHolder(view)
     }

     override fun getItemCount(): Int {
         return memoList.size
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val currentItem = memoList[position]
         holder.itemView.findViewById<TextView>(R.id.tvMemoTitle).text = currentItem.memoTitle
         holder.itemView.findViewById<TextView>(R.id.tvMemoBody).text = currentItem.memoBody
         holder.itemView.findViewById<ConstraintLayout>(R.id.memoItemContainer).setOnClickListener {

         }
     }
 }