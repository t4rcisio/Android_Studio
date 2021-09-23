package com.example.bank_login.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.bank_login.Business.BusinessSigin
import com.example.bank_login.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBusinessSigin : BusinessSigin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        if(supportActionBar != null)
            supportActionBar!!.hide()
        mBusinessSigin = BusinessSigin(this)
        passwordVisibility.setOnClickListener(this)
        siginbutton.setOnClickListener(this)
        passwordChangeEvent()

    }

    private fun passwordChangeEvent(){
        password.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                println("before")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mBusinessSigin.emptyPassoword(password,pswText,errorEmptyPassword)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun onClick(){
        if(mBusinessSigin.emptyPassoword(password,pswText,errorEmptyPassword)){
           startActivity(Intent(this,MainActivity::class.java))
        }
    }


    override fun onClick(v: View) {
        var id = v.id
        when(id){
            R.id.passwordVisibility -> mBusinessSigin.changePasswordVisibility(password, passwordVisibility)
            R.id.siginbutton -> onClick()
        }
    }



}