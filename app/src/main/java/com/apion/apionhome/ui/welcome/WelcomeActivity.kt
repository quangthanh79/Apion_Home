package com.apion.apionhome.ui.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.apion.apionhome.R
import com.apion.apionhome.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_pincode.*
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity(),WelcomeContract.View {


    override var presenter: WelcomeContract.Presenter? = WelcomePresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_welcome)
        button.setOnClickListener{
            presenter?.go()
        }
    }
    override fun goInputPassword() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}