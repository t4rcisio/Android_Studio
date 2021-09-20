package com.example.layut

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeBackgoundColor(black,blue,orange,yellow,green,grey,purpe,pink,white)

    }

    private fun changeBackgoundColor(vararg buttons: Button){
        for(button in buttons){
            button.setOnClickListener {
                backgoundLayout.setBackgroundColor(button.currentTextColor)
            }
        }

    }





}



