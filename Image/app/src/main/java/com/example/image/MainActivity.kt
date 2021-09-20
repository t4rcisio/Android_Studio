package com.example.image

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        checkEventBox(checkAzul,checkVerde)

    }


    private fun uncheck(boxes: Array<out CheckBox>, color : Int){
        for(box in boxes){
            if(box.currentTextColor != color){
                box.isChecked = false
            }
        }
    }

    private fun checkEventBox( vararg boxes : CheckBox){
        for(box in boxes){
            box.setOnCheckedChangeListener { v, checked ->
                if(checked){
                    imagem.setColorFilter(box.currentTextColor)
                    uncheck(boxes,box.currentTextColor)
                }
            }
        }
    }





}


