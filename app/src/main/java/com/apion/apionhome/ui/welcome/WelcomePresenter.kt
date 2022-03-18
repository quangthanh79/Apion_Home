package com.apion.apionhome.ui.welcome

class WelcomePresenter(val welcomeView: WelcomeContract.View) : WelcomeContract.Presenter {
    override fun go() {
        welcomeView.goInputPassword()
    }

    override fun start() {
        TODO("Not yet implemented")
    }
}