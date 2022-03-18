package com.apion.apionhome.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.apion.apionhome.R
import com.apion.apionhome.ui.home.FragmentDashboard.DashboardFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.statusBarColor = Color.TRANSPARENT
        setContentView(R.layout.activity_home)
        var fm = supportFragmentManager
        var dashboardFragment = DashboardFragment(this)

        fm.beginTransaction().add(R.id.fragment, dashboardFragment, "1").commit()

    }

}