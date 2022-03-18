package com.apion.apionhome.data.source.remote.model

import com.apion.apionhome.data.model.Dashboard
import com.google.gson.annotations.SerializedName

data class DashboardResponse(
    @SerializedName("success")
    var success:Boolean,
    @SerializedName("data")
    var data: Dashboard,
    @SerializedName("message")
    var message: String,
    )
