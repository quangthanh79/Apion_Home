package com.apion.apionhome.ui.login

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.apion.apionhome.R
import com.apion.apionhome.ui.pincode.PincodeActivity
import com.bumptech.glide.Glide
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import kotlinx.android.synthetic.main.activity_login.*
import java.util.concurrent.TimeUnit


class LoginActivity : AppCompatActivity(),LoginContract.View {
    companion object {
        const val TAG:String = "LoginActivity"
    }
    override var presenter: LoginContract.Presenter? = LoginPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        Glide.with(this)
//                .load("http://apionhome.com/public/banner/banner1.jpg")
//                .into(imageView3)
        btnLogin.setOnClickListener{
            presenter?.login(editPhoneNumber.text.toString())
        }
    }
    override fun showMsg(message: String) {
        val inflater = layoutInflater
        val alertLayout = inflater.inflate(R.layout.layout_custom_dialog,null)
        val alert = AlertDialog.Builder(this)
        alert.setView(alertLayout)
        val dialog = alert.create()
        var text = alertLayout.findViewById(R.id.content) as TextView?
        var button = alertLayout.findViewById(R.id.buttonClose) as Button?
        text?.setText(message)


        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.getWindow()?.setLayout(800, 450)

        button?.setOnClickListener{
            dialog.dismiss()
        }


    }

    override fun goPinCode(pincode:String?){
       var intent = Intent(this, PincodeActivity::class.java)
       intent.putExtra("pincode",pincode)
       startActivity(intent)
    }

}