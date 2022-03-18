package com.apion.apionhome.data.repository

import com.apion.apionhome.data.OnDataCallback
import com.apion.apionhome.data.model.User
import com.apion.apionhome.data.source.DashboardDatasource
import com.apion.apionhome.data.source.remote.model.DashboardResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardRepository(private val remote: DashboardDatasource.Remote) {
    var data_response : DashboardResponse? = null
    var name = "Phạm Anh Tuấn"

    fun getDasboard(callback: OnDataCallback<DashboardResponse>){
        remote.getDashboard(object: Callback<DashboardResponse>{
            override fun onResponse(
                call: Call<DashboardResponse>,
                response: Response<DashboardResponse>
            ) {
                if(response.body()?.success == true){
                    callback.onSuccess(response.body())
                }
            }

            override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }
    fun loadBanner(callback : OnDataCallback<ArrayList<String>>){
//        println("PAD1")
//        println(name)
//        println(data_response?.data?.banner.toString())

        if(data_response != null){
//                println(data_response?.data?.banner.toString())
//                println("PAD")

            }
        else {

            }
    }
}