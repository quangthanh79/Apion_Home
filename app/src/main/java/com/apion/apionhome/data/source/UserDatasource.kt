package com.apion.apionhome.data.source

import com.apion.apionhome.data.OnDataCallback
import com.apion.apionhome.data.source.remote.model.LoginResponse


interface UserDatasource {
    interface Remote {
         fun login(phone: String, callback: OnDataCallback<LoginResponse>)
    }
}