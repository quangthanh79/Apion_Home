package com.apion.apionhome.data.model

import com.google.gson.annotations.SerializedName
 open class House(
    @SerializedName("id")
    var id: Int = -1,
    @SerializedName("news_type")
    var news_type: String = "",
    @SerializedName("houseType")
    var houseType: String = "",
    @SerializedName("status")
    var status: String = "",
    @SerializedName("title")
    var title: String = "",
    @SerializedName("content")
    var content: String = "",
    @SerializedName("province")
    var province: String ="",
    @SerializedName("district")
    var district: String = "",
    @SerializedName("ward")
    var ward: String = "",
    @SerializedName("street")
    var street: String = "",
    @SerializedName("detail_address")
    var detail_address: String? = null,
    @SerializedName("price")
    var price: Long = -1,
    @SerializedName("acreage")
    var acreage: Int = -1,
    @SerializedName("frontWidth")
    var frontWidth: Int? = null,
    @SerializedName("bedrooms")
    var bedrooms: Int? = null,
    @SerializedName("homeDirection")
    var homeDirection: String = "",
    @SerializedName("images")
    var images: List<String> = emptyList(),
    @SerializedName("housing_broker_phone")
    var housing_broker_phone: String ="",
    @SerializedName("housing_broker_name")
    var housing_broker_name: String ="",
    @SerializedName("commission_rate")
    var commission_rate: String ="",
    @SerializedName("user_id")
    var user_id: Int = -1,
    @SerializedName("seller_id")
    var seller_id: String? = null,// chua xac dinh kieu
    @SerializedName("community_id")
    var community_id: String? = null,// chua xac dinh kieu
    @SerializedName("created_at")
    var created_at: String ="",
    @SerializedName("updated_at")
    var updated_at: String ="",


)
