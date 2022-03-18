package com.apion.apionhome.data.model

import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("image")
    var image:String,
    @SerializedName("link")
    var link:String,
    @SerializedName("title")
    var title:String,
    @SerializedName("created_at")
    var created_at:String,
)
