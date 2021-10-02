package com.example.bookrecipe.ui

import Business.Business_login
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import com.example.bookrecipe.R
import kotlinx.android.synthetic.main.activity_login.*

class Login_Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBusiness_login: Business_login
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mBusiness_login = Business_login(this)

        if(supportActionBar != null)
            supportActionBar!!.hide()

        Login_loginButton.setOnClickListener(this)
        listnerInput(Login_username,Login_password)

    }

    private fun listnerInput(vararg arrayinptText: EditText){
        for(editText in arrayinptText){
            editText.addTextChangedListener(object : TextWatcher {

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    when(editText.id){
                        R.id.Login_username -> mBusiness_login.verifyUser(editText)
                        R.id.Login_password -> mBusiness_login.verifyPassword(editText)
                    }

                }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun afterTextChanged(s: Editable?) {}

            })
        }
    }

    override fun onClick(v: View) {
        var id = v.id
        when(id){
            R.id.Login_loginButton -> if(mBusiness_login.onclickLogin(Login_username,Login_password)){startActivity(Intent(this,MainActivity::class.java))}
        }
    }
}