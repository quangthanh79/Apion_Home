package com.apion.apionhome.data.model

import com.google.gson.annotations.SerializedName

data class MyHouse(
    @SerializedName("owner")
    val owner: User,
    @SerializedName("seller")
    var seller: String? = null,
    @SerializedName("related_houses")
    var related_houses:List<MyHouse> = emptyList()

): House(){

}
