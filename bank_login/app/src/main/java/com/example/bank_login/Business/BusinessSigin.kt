package com.example.bank_login.Business

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import com.example.bank_login.R


class BusinessSigin(var context: Context) {



    fun changePasswordVisibility(password: EditText, icon: ImageView){

        if(password.inputType == 129){
            password.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            password.setSelection(password.length())
            password.setTypeface(Typeface.SANS_SERIF);
            icon.setImageResource(R.drawable.ic_baseline_visibility_24)
        }else{
            password.inputType = 129
            password.setSelection(password.length())
            icon.setImageResource(R.drawable.ic_baseline_visibility_off_24)
            password.setTypeface(Typeface.SANS_SERIF);
        }

    }

    fun emptyPassoword(password: EditText, passwordText: TextView, errorEmpty: TextView): Boolean{
        return if(password.text.toString().any()){
            password.background.setTint(ContextCompat.getColor(context,R.color.editTextDef))
            passwordText.setTextColor(ContextCompat.getColor(context,R.color.text))
            errorEmpty.setTextColor(ContextCompat.getColor(context,R.color.text))
            errorEmpty.setText(R.string.empty)
            true
        }else{

            password.background.setTint(ContextCompat.getColor(context, R.color.errorBox))
            passwordText.setTextColor(ContextCompat.getColor(context,R.color.errorTex))
            errorEmpty.setTextColor(ContextCompat.getColor(context,R.color.errorTex))
            errorEmpty.setText(R.string.campo_obrigat_rio)
            false
        }
    }

    fun sigin(){

    }



}