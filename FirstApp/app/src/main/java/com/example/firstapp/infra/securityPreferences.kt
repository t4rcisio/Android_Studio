package com.example.firstapp.infra

import android.content.Context


class securityPreferences(val context: Context) {

    private val mSharedPreferences = context.getSharedPreferences("firstApp", Context.MODE_PRIVATE)

    fun storeString(key : String, value: String){
        mSharedPreferences.edit().putString(key,value).apply()
    }
    fun getString(key: String): String{
        var data = mSharedPreferences.getString(key, "")
        return if(data != null){
            data.toString()
        }else{
            ""
        }
    }

}