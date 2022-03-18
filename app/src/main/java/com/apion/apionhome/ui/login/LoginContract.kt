package com.apion.apionhome.ui.login

import com.apion.apionhome.base.BasePresenter
import com.apion.apionhome.base.BaseView

interface LoginContract {
    interface Presenter : BasePresenter {
        fun login(phone:String)
    }
    interface View : BaseView<Presenter?> {
        fun showMsg(message: String)
        fun goPinCode(pincode:String?)
    }
}