package com.apion.apionhome.data.source.remote

import com.apion.apionhome.data.model.User
import com.apion.apionhome.data.source.remote.model.DashboardResponse
import com.apion.apionhome.data.source.remote.model.LoginRequest
import com.apion.apionhome.data.source.remote.model.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface RestApi {
//    @GET("api/live")
//    fun getUser(@Query("access_key") access_key: String,
//                @Query("currencies") currencies:String,
//                @Query("source") source:String,
//                @Query("format") format:Int,): Call<Currency>
    @POST("login")
    fun loginUser(@Body abc: LoginRequest) : Call<LoginResponse>

    @GET("dashboards")
    fun dashboard() : Call<DashboardResponse>
}