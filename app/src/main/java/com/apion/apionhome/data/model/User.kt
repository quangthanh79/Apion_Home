package com.apion.apionhome.data.model

import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("referal")
    val referal: String,
    @SerializedName("dob")
    val dob: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("sex")
    val sex: String,
    @SerializedName("academicLevel")
    val academicLevel: String,
    @SerializedName("job")
    val job: String,
    @SerializedName("pincode")
    val pincode: String,
    @SerializedName("isFirst")
    val isFirst: Int,
    @SerializedName("position")
    val position: String,
    @SerializedName("permission")
    val permission: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("facebook_id")
    val facebook_id: String,
    @SerializedName("bios")
    val bios: String,
    @SerializedName("role")
    val role: String,
    @SerializedName("employee_id")
    val employee_id: Int,
    @SerializedName("boss_id")
    val boss_id: Int,
    @SerializedName("community_id")
    val community_id: String?= null, // chua ro kieu
    @SerializedName("remember_token")
    val remember_token: String,
    @SerializedName("created_at")
    val created_at: String,
    @SerializedName("updated_at")
    val updated_at: String,
    @SerializedName("my_houses_count")
    val my_houses_count: Int?,
    @SerializedName("my_staff_count")
    val my_staff_count: Int?,
    @SerializedName("house_sold_count")
    val house_sold_count: Int?,
    @SerializedName("participants_count")
    val participants_count: Int?,
    @SerializedName("boss")
    val boss: User,

    @SerializedName("my_houses")
    val my_houses: List<House>?,
    @SerializedName("house_sold")
    val house_sold: List<House>?,
    @SerializedName("houses_bookmark")
    val houses_bookmark: List<House>?,

    @SerializedName("participants")
    val participants: List<House>?,
)
