package com.apion.apionhome.data.source.remote

import com.apion.apionhome.data.OnDataCallback
import com.apion.apionhome.data.source.DashboardDatasource
import com.apion.apionhome.data.source.remote.model.DashboardResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardRemoteDatasource : DashboardDatasource.Remote {
    override fun getDashboard(callback: Callback<DashboardResponse>) {
        val retrofit = BaseRemote2.buildService(RestApi::class.java)
        val response = retrofit.dashboard().enqueue(callback)
    }
}