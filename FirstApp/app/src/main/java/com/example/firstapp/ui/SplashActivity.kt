package com.example.firstapp.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.firstapp.R
import com.example.firstapp.infra.appConstants
import com.example.firstapp.infra.securityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSharedPreferences : securityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if(supportActionBar != null)
            supportActionBar!!.hide()

        savebutton.setOnClickListener(this)

        mSharedPreferences = securityPreferences(this)

    }


    private fun namecheck(): Boolean{
        return (username.text.toString().any())
    }

    private fun nextPage(){

        if(namecheck()){
            mSharedPreferences.storeString(appConstants.KEY.PERSON_NAME,username.text.toString())
            startActivity(Intent(this, MainActivity::class.java))
        }else{
            Toast.makeText(this,"Invalid name",Toast.LENGTH_LONG).show()
        }
    }

    override fun onClick(v: View) {
        var id = v.id
        when(id){
            R.id.savebutton -> nextPage()
        }
    }

}