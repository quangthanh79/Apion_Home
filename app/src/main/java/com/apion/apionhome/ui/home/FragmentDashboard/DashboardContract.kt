package com.apion.apionhome.ui.home.FragmentDashboard

import com.apion.apionhome.base.BasePresenter
import com.apion.apionhome.base.BaseView
import com.apion.apionhome.data.model.Feature

interface DashboardContract {
    interface Presenter : BasePresenter{
        fun loadBanner()
    }
    interface View : BaseView<Presenter>{
        fun updateListImage(list_url:ArrayList<String>)
        fun updateListLandHigh(list_feature: ArrayList<Feature>)
        fun updateHanoi(list_hanoi:  ArrayList<Feature>)
        fun updateSaiGon(list_saigon: ArrayList<Feature>)
    }
}