package com.apion.apionhome.ui.home.adaper

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.apion.apionhome.R
import com.apion.apionhome.data.model.Photo
import com.bumptech.glide.Glide


class PhotoAdapter(val mListPhoto: List<String>, val mcontext: Activity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        if(mListPhoto != null ){
            return mListPhoto.size
        }
        return 0
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_photo,parent,false)
        val viewHolder = StatisticViewHolder(view,mcontext)
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var url = mListPhoto.get(position) as String
        (holder as StatisticViewHolder).setStatisticContent(url)

    }
    class StatisticViewHolder(itemView: View, val mcontext: Activity ) : RecyclerView.ViewHolder(itemView) {
        val imgView = itemView.findViewById(R.id.img_photo) as ImageView

        fun setStatisticContent(url:String){
            Glide.with(mcontext)
                .load(url)
                .into(imgView)
        }

    }
}