package com.apion.apionhome.ui.pincode

class PincodePresenter(val pincodeView : PincodeContract.View) : PincodeContract.Presenter {
    override fun check(pincodeRes: String?, pincodeDes: String) {
        if(pincodeDes.length != 4){
            pincodeView.showDialog2()
        }
        else{
            if(pincodeRes.equals(pincodeDes)){
                pincodeView.goHome()
            } else{
                pincodeView.showDialog()
            }
        }
    }

    override fun start() {

    }
}