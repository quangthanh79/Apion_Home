package com.apion.apionhome.ui.pincode

import com.apion.apionhome.base.BasePresenter
import com.apion.apionhome.base.BaseView

interface PincodeContract {
    interface Presenter: BasePresenter{
        fun check(pincodeRes:String?,pincodeDes:String)
    }
    interface View: BaseView<Presenter>{
        fun showDialog()
        fun showDialog2()
        fun goHome()
    }
}