package com.example.guests_20.viewModel

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.widget.RadioButton
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.guests_20.service.constants.Constants
import com.example.guests_20.service.model.GuestModel
import com.example.guests_20.service.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private var mGuestRepository : GuestRepository = GuestRepository(mContext)

    private var dataInputError = MutableLiveData<Boolean>()
    var inputError: LiveData<Boolean> = dataInputError

    private var gender : MutableLiveData<String> = MutableLiveData()
    var genderNotify : LiveData<String> = gender

    private var checkBoxDataGender = MutableLiveData<Boolean>()
    var inputCheckBoxGender: LiveData<Boolean> = checkBoxDataGender

    private var checkBoxDataPresence = MutableLiveData<Boolean>()
    var inputCheckBoxPresence: LiveData<Boolean> = checkBoxDataPresence

    private var checkSaveGuest = MutableLiveData<Boolean>()
    var saveData : LiveData<Boolean> = checkSaveGuest

    private var checkUpdateGuest = MutableLiveData<Boolean>()
    var updateData : LiveData<Boolean> = checkUpdateGuest

    private var bundleAttach : MutableLiveData<GuestModel> = MutableLiveData()
    var guestAttach : LiveData<GuestModel> = bundleAttach

    private var dbDeleteResponse : MutableLiveData<Boolean> = MutableLiveData()
    var dbDeleteNotification : MutableLiveData<Boolean> = dbDeleteResponse

    private var presence : MutableLiveData<String> = MutableLiveData()
    var presenceNotification : LiveData<String> = presence



    fun checkCPF(cpf: String, level :Int = 0): Boolean{
        return try {
            if (cpf.any()) {

                if(cpf.length < 11 || cpf.length >11){
                    false
                }

                if(!checkCpfHGelper(cpf)){
                    return false
                }

                var max: Int = 11 - level
                var end: Int = 1 + level

                var total: Int = 0
                var div: Int

                for (i in 0..(cpf.length - (end + 1))) {
                    //println("Total = $total + ${cpf[i].digitToInt()} * $max")
                    try {
                        total += cpf[i].digitToInt() * max
                    } catch (e: Exception) {
                        dataInputError.value = false; dataInputError.value!!
                    }
                    max--
                }
                div = ((total * 10) % 11)

                if (div == 10)
                    div = 0
                //println(cpf[cpf.length -end])
                if (div == cpf[cpf.length - end].digitToInt() && level == 0) {
                    checkCPF(cpf, 1)
                } else {
                    dataInputError.value = div == cpf[(cpf.length - (end))].digitToInt()
                    return dataInputError.value!!
                }
            } else {
                dataInputError.value = false
                dataInputError.value!!
            }
            return dataInputError.value!!
        }catch (e: java.lang.Exception){

            dataInputError.value = false
            dataInputError.value!!
        }
    }

    private fun checkCpfHGelper(cpf: String): Boolean{
        var d1 = cpf[0].code
        for(dig in cpf){
            if(d1 != dig.code){
                return true
            }
        }
        return false
    }




    fun checkName(name: String):Boolean{
        dataInputError.value = name.any()
        return dataInputError.value!!
    }
    fun checkAdress(address: String):Boolean{
        dataInputError.value = address.any()
        return dataInputError.value!!
    }
    fun checkCity(city: String):Boolean{
        dataInputError.value = city.any()
        return dataInputError.value!!
    }
    fun checkAge(age: String):Boolean{
        dataInputError.value = age.any()
        return dataInputError.value!!
    }
    fun checkZipCode(zipcode: String): Boolean{
        dataInputError.value = zipcode.any()
        return dataInputError.value!!
    }
    fun checkPhone(phone: String): Boolean{
        dataInputError.value = phone.any()
        return dataInputError.value!!
    }
    fun checkGender(male: RadioButton, female: RadioButton, other: RadioButton):Boolean{
        checkBoxDataGender.value = female.isChecked || male.isChecked || other.isChecked

        if(checkBoxDataGender.value!!){

            gender.value = when {
                female.isChecked -> Constants.KEY.FEMALE
                male.isChecked -> Constants.KEY.MALE
                else -> Constants.KEY.OTHER
            }
        }
        return checkBoxDataGender.value!!
    }

    fun checkPresence(presenceConfirm: RadioButton, weaken: RadioButton): Boolean{

        checkBoxDataPresence.value = presenceConfirm.isChecked || weaken.isChecked
        if(checkBoxDataPresence.value!!){
            presence.value = when{
                presenceConfirm.isChecked -> Constants.FILTER.PRESENTS
                else -> Constants.FILTER.ABSENT
            }
        }
        return checkBoxDataPresence.value!!
    }

    fun saveGuest(name:String, genderGuest: String, age: String, cpf: String,address: String,city: String,zipcode: String,phone: String, ifpresence: String){
        if(
            checkName(name)
            && genderGuest.any()
            && checkAge(age)
            && checkCPF(cpf)
            && checkAdress(address)
            && checkCity(city)
            && checkZipCode(zipcode)
            && checkPhone(phone)
            && ifpresence.any()){

                var guest = GuestModel().apply {
                    this.id = 0
                    this.name = name
                    this.gender = genderGuest
                    this.age = age
                    this.cpf = cpf
                    this.address = address
                    this.city = city
                    this.zipcode = zipcode
                    this.phone = phone
                    this.presence = ifpresence
                }


                checkSaveGuest.value = mGuestRepository.createGuest(guest)

        }else{

            checkSaveGuest.value = false
        }
    }

    fun updateGuest(id: Int,genderGuest : String, name:String, age: String, cpf: String,address: String,city: String,zipcode: String,phone: String, ifpresence: String){
        if(
            checkName(name)
            && genderGuest.any()
            && checkAge(age)
            && checkCPF(cpf)
            && checkAdress(address)
            && checkCity(city)
            && checkZipCode(zipcode)
            && checkPhone(phone)
            && ifpresence.any()){

            var guest = GuestModel().apply {
                this.id = id
                this.name = name
                this.gender = genderGuest
                this.age = age
                this.cpf = cpf
                this.address = address
                this.city = city
                this.zipcode = zipcode
                this.phone = phone
                this.presence = ifpresence
            }

            checkUpdateGuest.value = mGuestRepository.updateGuest(guest)

        }else{

            checkUpdateGuest.value = false
        }
    }

    fun getGuest(id: Int){

        bundleAttach.value =  mGuestRepository.readGuest(id)

    }

    fun deleteGuest(id: Int){

        dbDeleteResponse.value =  mGuestRepository.deleteGuest(mGuestRepository.readGuest(id)!!)
    }



}