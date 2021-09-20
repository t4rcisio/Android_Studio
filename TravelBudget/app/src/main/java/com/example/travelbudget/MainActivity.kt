package com.example.travelbudget

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculeButton.setOnClickListener(this)
        focusCheck(userDistance,fuelCost,autonomy)


    }

    override fun onClick(view: View) {
        val id = view.id
        when(id){
            R.id.calculeButton -> calculate()
        }

    }


    private fun focusCheck(vararg inputBox : EditText){
        for( box in inputBox){
            box.setOnFocusChangeListener { v, hasFocus ->
                if(hasFocus){
                    if(checkConteten(box)){
                        errorAlertEvent(v,Color.BLACK)
                    }else{
                        errorAlertEvent(v,Color.RED)
                    }
                }else{
                    if(checkConteten(box)){
                        errorAlertEvent(v,Color.BLACK)
                    }else{
                        errorAlertEvent(v,Color.RED)
                    }
                }
            }
        }
    }

    private fun errorAlertEvent(view: View, color: Int){
        val id = view.id
        when(id){
            R.id.userDistance -> distanceText.setTextColor(color)
            R.id.fuelCost -> fuelCostText.setTextColor(color)
            R.id.autonomy -> autonomyText.setTextColor(color)
        }
    }

    private fun checkConteten(inputBox: EditText): Boolean{
        return try{
           return (inputBox.text.toString().toFloat() > 0 && inputBox.text.toString().any())
        }catch (e : Exception){
            false
        }
    }


    private fun calculate(){

        if(checkConteten(userDistance) && checkConteten(fuelCost) && checkConteten(autonomy)){
            var cost = (userDistance.text.toString().toFloat() / autonomy.text.toString().toFloat())
            cost = cost * fuelCost.text.toString().toFloat()

            total.text = "R$ ${"%.2f".format(cost)}"

        }else{
            focusCheck(userDistance,fuelCost,autonomy)
        }
    }
}