package com.apion.apionhome.data.model

import com.google.gson.annotations.SerializedName

data class Dashboard(
    @SerializedName("user_online")
    var user_online: List<User>,
    @SerializedName("user_online_count")
    var user_online_count: Int,
    @SerializedName("total_user")
    var total_user: Int,
    @SerializedName("feature")
    var feature:List<MyHouse>,
    @SerializedName("hanoi")
    var hanoi: List<MyHouse>,
    @SerializedName("saigon")
    var saigon: List<MyHouse>,
    @SerializedName("banner")
    var banner:List<Banner>,
    @SerializedName("featured_community")
    var featured_community:List<MyHouse>,
    @SerializedName("communities")
    var communities:List<Object>

)
