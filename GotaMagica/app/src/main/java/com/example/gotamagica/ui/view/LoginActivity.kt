package com.example.gotamagica.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelStoreOwner
import com.example.gotamagica.R
import com.example.gotamagica.viewModel.LoginViewModel

class LoginActivity : AppCompatActivity(), ViewModelStoreOwner {

    private lateinit var mLoginViewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mLoginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        if(supportActionBar != null)
            supportActionBar!!.hide()


    }
}
