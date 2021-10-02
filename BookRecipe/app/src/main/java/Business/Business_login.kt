package Business

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.text.BoringLayout
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.example.bookrecipe.R
import com.example.bookrecipe.ui.MainActivity

class Business_login (var context: Context){


     fun verifyUser(editText: EditText): Boolean{
       return if(editText.text.toString().any()){
            inputDefautStyle(editText)
            true
       }else{
           inputErrorStyle(editText)
           false
       }
    }
    fun verifyPassword(editText: EditText): Boolean{
        return if(editText.text.toString().any()){
            inputDefautStyle(editText)
            true
        }else{
            inputErrorStyle(editText)
            false
        }
    }

    fun onclickLogin(userInput: EditText, passwordInput: EditText): Boolean{
        var v1 = (verifyUser(userInput))
        var v2 = (verifyPassword(passwordInput))
        return (v1 && v2)

    }

    private fun inputErrorStyle(editText: EditText){
        editText.background.setTint(ContextCompat.getColor(context, R.color.errorBox))
    }
    private fun inputDefautStyle(editText: EditText){
        editText.background.setTint(ContextCompat.getColor(context, R.color.login_input_color_background))
    }



}