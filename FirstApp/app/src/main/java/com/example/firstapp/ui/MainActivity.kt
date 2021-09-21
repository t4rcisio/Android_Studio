package com.example.firstapp.ui

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.firstapp.R
import com.example.firstapp.infra.appConstants
import com.example.firstapp.infra.securityPreferences
import com.example.firstapp.repository.QuotRepository
import com.example.firstapp.repository.Quote
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSharedPreferences : securityPreferences
    private val mQuotRepository = QuotRepository()
    private var mOldImageView : ImageView? = null
    private var filter = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(supportActionBar != null)
            supportActionBar!!.hide()

        mSharedPreferences = securityPreferences(this)
        username.text = "Hello, ${mSharedPreferences.getString(appConstants.KEY.PERSON_NAME)}"

        newQuote.setOnClickListener(this)
        show_god_morning.setOnClickListener(this)
        show_all.setOnClickListener(this)
        show_happy.setOnClickListener(this)
    }

    private fun selectFilter(icon: ImageView, filter: String ){


        if(mOldImageView != null) {
            mOldImageView?.setColorFilter(Color.WHITE)
        }
        icon.setColorFilter(Color.GRAY)
        this.filter = filter
        mOldImageView = icon

    }

    private fun newQuote(){
        if(!filter.any()){
            Toast.makeText(this,"Select a icon filter",Toast.LENGTH_LONG).show()
        }else {
            var mQuote: Quote = mQuotRepository.getQuote(filter)
            quote.text = mQuote.quote
            author.text = "- ${mQuote.author}"
        }
    }


    override fun onClick(v: View) {
        var id = v.id
        when(id){
            R.id.newQuote -> newQuote()
            R.id.show_all -> selectFilter(show_all, appConstants.KEY.ALL)
            R.id.show_god_morning -> selectFilter(show_god_morning, appConstants.KEY.MORNING)
            R.id.show_happy -> selectFilter(show_happy, appConstants.KEY.HAPPY)
        }
    }






}