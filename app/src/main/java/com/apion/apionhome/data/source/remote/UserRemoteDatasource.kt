package com.apion.apionhome.data.source.remote

import com.apion.apionhome.base.exception.ApiError
import com.apion.apionhome.base.exception.LoginException
import com.apion.apionhome.data.OnDataCallback
import com.apion.apionhome.data.model.MyHouse
import com.apion.apionhome.data.model.User
import com.apion.apionhome.data.source.UserDatasource
import com.apion.apionhome.data.source.remote.model.LoginRequest
import com.apion.apionhome.data.source.remote.model.LoginResponse
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserRemoteDatasource : UserDatasource.Remote{

    override fun login(phone: String, callback: OnDataCallback<LoginResponse>) {
        val loginRequest = LoginRequest(phone)
        val retrofit = BaseRemote2.buildService(RestApi::class.java)
        val response = retrofit.loginUser(loginRequest).enqueue(object:Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if(response.body()?.success == true){
                    callback.onSuccess(response.body())
                }else {
                    val apiError =  Gson().fromJson(response.errorBody()?.charStream(), ApiError::class.java)

                    callback.onError( LoginException(apiError.message))
                }
            }
           override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                callback.onError(t)
            }

        })

    }


}



