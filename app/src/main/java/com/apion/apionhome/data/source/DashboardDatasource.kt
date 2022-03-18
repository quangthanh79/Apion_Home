package com.apion.apionhome.data.source

import com.apion.apionhome.data.OnDataCallback
import com.apion.apionhome.data.source.remote.model.DashboardResponse
import retrofit2.Callback

interface DashboardDatasource {
    interface Remote{
        fun getDashboard(callback: Callback<DashboardResponse>)
    }
}