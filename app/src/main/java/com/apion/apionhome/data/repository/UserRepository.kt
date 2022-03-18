package com.apion.apionhome.data.repository

import com.apion.apionhome.data.OnDataCallback
import com.apion.apionhome.data.model.User
import com.apion.apionhome.data.source.UserDatasource
import com.apion.apionhome.data.source.remote.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(private val remote: UserDatasource.Remote){
    fun login(phone:String, callback:OnDataCallback<User>){
        remote.login(phone, object: OnDataCallback<LoginResponse>{
            override fun onSuccess(data: LoginResponse?) {
                val user = data?.user
                callback.onSuccess(user)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }


        })
    }
}