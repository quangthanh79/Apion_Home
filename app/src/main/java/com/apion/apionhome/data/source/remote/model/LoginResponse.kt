package com.apion.apionhome.data.source.remote.model

import com.apion.apionhome.data.model.User
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val user: User?
)
