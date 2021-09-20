package com.example.relativelayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class MainActivity : AppCompatActivity() {
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var day = LocalDate.now().getDayOfWeek()
        var dayofmonth = LocalDate.now().dayOfMonth
        var month = LocalDate.now().month

        data.text = "$day, $dayofmonth of $month ".lowercase()

        isDone(check01,check02)


    }

    private fun isDone(vararg checkBoxes: CheckBox){
        done.text="Complete all checkbox"
        for(box in checkBoxes){
            box.setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked){
                    counter++
                    if(counter == checkBoxes.size){
                        done.text= "Done!"
                    }
                }else{
                    counter--
                    done.text = "Complete all checkbox"
                }
            }
        }
    }

}