package com.apion.apionhome.ui.login

import com.apion.apionhome.base.exception.LoginException
import com.apion.apionhome.data.OnDataCallback
import com.apion.apionhome.data.model.User
import com.apion.apionhome.data.repository.UserRepository
import com.apion.apionhome.data.source.remote.UserRemoteDatasource
import com.apion.apionhome.data.source.remote.model.LoginResponse

class LoginPresenter(val loginView:LoginContract.View) : LoginContract.Presenter {
   val repository = UserRepository(UserRemoteDatasource())
    override fun login(phone: String) {
        repository.login(phone,object : OnDataCallback<User>{
            override fun onSuccess(data: User?) {
               loginView.goPinCode(data?.pincode)
            }
            override fun onError(throwable: Throwable) {
                if(throwable is LoginException){
                    loginView.showMsg(throwable.message?:"Có lỗi xảy ra")
                }
                throwable.printStackTrace()
            }
        })
//        loginView.goPinCode(phone)
    }

    override fun start() {

    }
}