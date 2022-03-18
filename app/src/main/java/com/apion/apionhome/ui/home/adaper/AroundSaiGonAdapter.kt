package com.apion.apionhome.ui.home.adaper

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apion.apionhome.R
import com.apion.apionhome.data.model.Feature
import com.bumptech.glide.Glide
import java.util.ArrayList

class AroundSaiGonAdapter(val mList: ArrayList<Feature>, val mcontext: Activity)  : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var  view = LayoutInflater.from(parent.context).inflate(R.layout.item_saigon, parent, false)
        return ViewHolder(view, mcontext)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var feature = mList[position]
        var holder: ViewHolder = holder as ViewHolder
        holder.setHeaderView(feature)
    }

    override fun getItemCount(): Int {
        if(mList != null ){
            return mList.size
        }
        return 0
    }
    class ViewHolder(itemView: View, val mcontext: Activity) : RecyclerView.ViewHolder(itemView) {
        lateinit var txt_price_high: TextView
        lateinit var txt_address_high: TextView
        lateinit var imgHigh: ImageView
        init {
            txt_price_high = itemView.findViewById<View>(R.id.txt_price_high) as TextView
            txt_address_high = itemView.findViewById<View>(R.id.txt_address_high) as TextView
            imgHigh = itemView.findViewById<View>(R.id.imgHigh) as ImageView
        }
        fun setHeaderView(feature : Feature) {
            txt_address_high.text = feature.address
            txt_price_high.text = convertPriceToString(feature.price)
            Glide.with(mcontext)
                .load(feature.image)
                .into(imgHigh)
        }
        fun convertPriceToString(price: Long) : String{
            var part_integer = price/1000000000
            var part_decimal = (price - part_integer*1000000000)/10000000
            var result = ""+ part_integer + "." + part_decimal+" tỷ"
            return result
        }


    }
}