package com.example.bank_login.Business

import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.example.bank_login.ui.LoginActivity
import kotlinx.android.synthetic.main.activity_login.*

class BusinessSigin {


    fun changePasswordVisibility(password: EditText, icon: ImageView, id_hidden : Int,  id_visible: Int){
        if(password.inputType == 129){
            println("Texto")
            password.inputType = InputType.TYPE_CLASS_TEXT
            password.setSelection(password.length())
            icon.setImageResource(id_hidden)
        }else{
            println("Senha")
            password.inputType = 129
            password.setSelection(password.length())
            icon.setImageResource(id_visible)
        }

    }



}