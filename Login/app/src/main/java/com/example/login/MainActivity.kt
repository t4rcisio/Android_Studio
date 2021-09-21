package com.example.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edditTextCheck(mail,password)

    }


    private fun errorInputAlert(v : View){
        var id = v.id
        println("ID $id - ${R.id.mail}")
        when(id){
            R.id.mail -> incorrectMail.text = "Invalid mail"
            R.id.password -> incorrectPassword.text = "Invalid password"
        }

    }

    private fun edditTextCheck(vararg editText: EditText){

        for(text in editText){
            text.addTextChangedListener(text : TextWatcher = TextWatcher())
        }

    }


    private fun checkContent(editText: EditText): Boolean{
        return if(editText.text.any()){
            editText.setBackgroundResource( R.drawable.edittext_style_done)
            true
        }else{
            editText.setBackgroundResource( R.drawable.edittext_style_error)
            false
        }
    }


    private fun logginButton(){

    }
}