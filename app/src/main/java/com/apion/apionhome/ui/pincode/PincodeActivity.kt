package com.apion.apionhome.ui.pincode

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.apion.apionhome.R
import com.apion.apionhome.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_pincode.*


class PincodeActivity : AppCompatActivity(),PincodeContract.View {


    override var presenter: PincodeContract.Presenter = PincodePresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pincode)
        var intent = this.intent
        etPassword1.setCursorVisible(false)
        etPassword2.setCursorVisible(false)
        etPassword3.setCursorVisible(false)
        etPassword4.setCursorVisible(false)// ẩn con trỏ chuột

        etPassword1.setOnKeyListener(GenericKeyEvent(etPassword1, null))
        etPassword2.setOnKeyListener(GenericKeyEvent(etPassword2, etPassword1))
        etPassword3.setOnKeyListener(GenericKeyEvent(etPassword3, etPassword2))
        etPassword4.setOnKeyListener(GenericKeyEvent(etPassword4,etPassword3))

        etPassword1.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {
                if (etPassword1.getText().toString().length === 1) //size as per your requirement
                {
                    etPassword2.requestFocus()
                }
            }
        })
        etPassword2.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {
                if (etPassword2.getText().toString().length === 1) //size as per your requirement
                {
                    etPassword3.requestFocus()
                }

                // TODO Auto-generated method stub
            }
        })
        etPassword3.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // TODO Auto-generated method stub

            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {
                if (etPassword3.getText().toString().length === 1) //size as per your requirement
                {
                    etPassword4.requestFocus()
                }
                // TODO Auto-generated method stub
            }
        })
        etPassword4.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // TODO Auto-generated method stub

            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {

                // TODO Auto-generated method stub
            }
        })

        buttonlogin.setOnClickListener{
            presenter.check(intent.getStringExtra("pincode"),etPassword1.text.toString()
                                                                            + etPassword2.text.toString()
                                                                            + etPassword3.text.toString()
                                                                            + etPassword4.text.toString()
            )

        }
    }
    override fun showDialog() {
        val inflater = layoutInflater
        val alertLayout = inflater.inflate(R.layout.layout_custom_dialog,null)
        val alert = AlertDialog.Builder(this)
        alert.setView(alertLayout)
        val dialog = alert.create()
        var text = alertLayout.findViewById(R.id.content) as TextView?
        var button = alertLayout.findViewById(R.id.buttonClose) as Button?
        text?.setText("Pincode không trùng khớp")
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.getWindow()?.setLayout(800, 450)

        button?.setOnClickListener{
            dialog.dismiss()
        }
    }
    override fun showDialog2(){
        val inflater = layoutInflater
        val alertLayout = inflater.inflate(R.layout.layout_custom_dialog,null)
        val alert = AlertDialog.Builder(this)
        alert.setView(alertLayout)
        val dialog = alert.create()
        var text = alertLayout.findViewById(R.id.content) as TextView?
        var button = alertLayout.findViewById(R.id.buttonClose) as Button?
        text?.setText("Vui lòng nhập đầy đủ pincode!")
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        dialog.getWindow()?.setLayout(800, 450)

        button?.setOnClickListener{
            dialog.dismiss()
        }
    }
    override fun goHome() {
        var intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }
    class GenericKeyEvent internal constructor(private val currentView: EditText, private val previousView: EditText?) : View.OnKeyListener{

        override fun onKey(p0: View?, keyCode: Int, event: KeyEvent?): Boolean {
            if(event!!.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL && currentView.id != R.id.etPassword1 && currentView.text.isEmpty()) {
                //If current is empty then previous EditText's number will also be deleted
                previousView!!.text = null
                previousView.requestFocus()
                return true
            }
            return false
        }


    }
}