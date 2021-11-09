package com.example.mvvm

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewMode() : ViewModel() {

    private var mTextMVVM = MutableLiveData<String>()
    var topTextData = mTextMVVM

    init {
        mTextMVVM.value = "MVVM Architecture"
    }

    fun login(){
        mTextMVVM.value = "Meu ovo"
    }
    fun changeTopText(string: String){
        mTextMVVM.value = string
    }
}