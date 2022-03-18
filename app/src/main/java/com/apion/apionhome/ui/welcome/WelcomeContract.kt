package com.apion.apionhome.ui.welcome

import com.apion.apionhome.base.BasePresenter
import com.apion.apionhome.base.BaseView

interface WelcomeContract {
    interface Presenter : BasePresenter{
        fun go()
    }
    interface View : BaseView<Presenter?>{
        fun goInputPassword()
    }
}