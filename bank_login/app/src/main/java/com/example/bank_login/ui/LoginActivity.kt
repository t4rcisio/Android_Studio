package com.example.bank_login.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.bank_login.Business.BusinessSigin
import com.example.bank_login.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private var mBusinessSigin = BusinessSigin()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        if(supportActionBar != null)
            supportActionBar!!.hide()

        passwordVisibility.setOnClickListener(this)
    }



    override fun onClick(v: View) {
        var id = v.id
        when(id){
            R.id.passwordVisibility -> mBusinessSigin.changePasswordVisibility(password, passwordVisibility,R.drawable.ic_baseline_visibility_off_24,R.drawable.ic_baseline_visibility_24)
        }
    }

}