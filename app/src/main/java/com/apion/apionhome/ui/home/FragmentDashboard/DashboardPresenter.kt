package com.apion.apionhome.ui.home.FragmentDashboard

import com.apion.apionhome.data.OnDataCallback
import com.apion.apionhome.data.model.Feature
import com.apion.apionhome.data.repository.DashboardRepository
import com.apion.apionhome.data.source.remote.DashboardRemoteDatasource
import com.apion.apionhome.data.source.remote.model.DashboardResponse

class DashboardPresenter(val dashboardView:DashboardContract.View) : DashboardContract.Presenter {
    val repository = DashboardRepository(DashboardRemoteDatasource())
    override fun loadBanner() {
        repository.loadBanner(object : OnDataCallback<ArrayList<String>>{
            override fun onSuccess(data: ArrayList<String>?) {
                println(data.toString())
                println("PAT")
//                dashboardView.updateListImage(data)
            }

            override fun onError(throwable: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun start() {
        repository.getDasboard(object: OnDataCallback<DashboardResponse>{
            override fun onSuccess(data: DashboardResponse?) {
                var dashboard = data?.data

                var feature = dashboard?.feature
                var banner = dashboard?.banner
                var hanoi = dashboard?.hanoi
                var saigon = dashboard?.saigon

                var listBanner = ArrayList<String>()
                var listFeature = ArrayList<Feature>()
                var listHanoi = ArrayList<Feature>()
                var listSaigon = ArrayList<Feature>()

                if(banner != null ) {
                    for (i in 0 until banner.size) {
                        listBanner.add(banner.get(i).image)
                    }
                }
                if(feature != null) {
                    for(i in 0 until feature.size){
                        var images = feature.get(i).images
                        var address = feature.get(i).district
                        var price = feature.get(i).price

                        listFeature.add(Feature(address,price,images[0]))

                    }
                }
                if(hanoi != null){
                    for(i in 0 until hanoi.size){
                        var images = hanoi.get(i).images
                        var address = hanoi.get(i).district
                        var price = hanoi.get(i).price

                        listHanoi.add(Feature(address,price,images[0]))
                    }
                }
                if(saigon != null){
                    for(i in 0 until saigon.size){
                        var images = saigon.get(i).images
                        var address = saigon.get(i).district
                        var price = saigon.get(i).price

                        listSaigon.add(Feature(address,price,images[0]))
                    }
                }
                dashboardView.updateListImage(listBanner)
                dashboardView.updateListLandHigh(listFeature)
                dashboardView.updateHanoi(listHanoi)
                dashboardView.updateSaiGon(listSaigon)
            }

            override fun onError(throwable: Throwable) {
            }

        })
    }
}