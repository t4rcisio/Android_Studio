package com.example.guests_20.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.guests_20.R
import com.example.guests_20.service.constants.Constants
import com.example.guests_20.service.model.GuestModel
import com.example.guests_20.viewModel.GuestFormViewModel
import kotlinx.android.synthetic.main.activity_guest_form.*

class GuestForm : AppCompatActivity(), View.OnClickListener {
    private lateinit var mViewModel: GuestFormViewModel
    private lateinit var boxData : EditText
    private var mEditMode : Boolean = false
    private var mID : Int = 0
    private var mGender : String = ""
    private var mPresence : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        if(supportActionBar != null)
            supportActionBar!!.hide()

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        loadIntent()
        boxData = form_guest_name
        inputListners(form_guest_name,form_guest_age,form_guest_id,form_guest_address,form_guest_city,form_guest_zipcode,form_guest_phone)
        confirmListner()



        mViewModel.inputCheckBoxGender.observe(this,{
            if(it){
                formGender.background.setTint(ContextCompat.getColor(this, R.color.white))
            }else{
                formGender.background.setTint(ContextCompat.getColor(this, R.color.errorTintBox))
            }
        })

        mViewModel.inputCheckBoxPresence.observe(this,{
            if(it){
                form_guest_confirmation_box.background.setTint(ContextCompat.getColor(this, R.color.white))
            }else{
                form_guest_confirmation_box.background.setTint(ContextCompat.getColor(this, R.color.errorTintBox))
            }
        })

        mViewModel.inputError.observe(this,{
            if(it){
                boxData.background.setTint(ContextCompat.getColor(this, R.color.defultTintBox))
            }else{
                boxData.background.setTint(ContextCompat.getColor(this, R.color.errorTintBox))
            }
        })

        mViewModel.saveData.observe(this,{
            if(it){
                    Toast.makeText(applicationContext,"Guest saved!", Toast.LENGTH_LONG).show()
                    finish()
            }else{
                Toast.makeText(applicationContext,"Missing data", Toast.LENGTH_LONG).show()
                verifyAll(form_guest_name, form_guest_age, form_guest_id, form_guest_address, form_guest_city, form_guest_zipcode, form_guest_phone)
            }
        })

        mViewModel.presenceNotification.observe(this,{
            mPresence = it
        })

        mViewModel.genderNotify.observe(this,{
            mGender = it
        })

        mViewModel.guestAttach.observe(this,{
            insertGuest(it)

        })

        mViewModel.dbDeleteNotification.observe(this,{
            if(it){
                Toast.makeText(this,"Guest deleted!",Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this,"Error to delete guest",Toast.LENGTH_LONG).show()
            }
        })

        mViewModel.updateData.observe(this,{
            if(it){
                Toast.makeText(this,"Guest updated!",Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this,"Error to update guest",Toast.LENGTH_LONG).show()
            }
        })


    }

    private fun confirmListner(){
        form_confirm_button.setOnClickListener(this)
        deleteGuest.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        var id = v.id
        when(id){
            R.id.form_confirm_button -> {
                checkBoxData()
                if(mEditMode){

                    mViewModel.updateGuest(
                        mID,
                        mGender,
                        form_guest_name.text.toString(),
                        form_guest_age.text.toString(),
                        form_guest_id.text.toString(),
                        form_guest_address.text.toString(),
                        form_guest_city.text.toString(),
                        form_guest_zipcode.text.toString(),
                        form_guest_phone.text.toString(),
                        mPresence

                    )
                }else {
                    mViewModel.saveGuest(
                        form_guest_name.text.toString(),
                        mGender,
                        form_guest_age.text.toString(),
                        form_guest_id.text.toString(),
                        form_guest_address.text.toString(),
                        form_guest_city.text.toString(),
                        form_guest_zipcode.text.toString(),
                        form_guest_phone.text.toString(),
                        mPresence
                    )
                }
            }
            R.id.deleteGuest -> {
                mViewModel.deleteGuest(mID)
            }

        }
    }

    private fun loadIntent(){
        var bundle = intent.extras

        if(bundle != null){

            var id = bundle.getInt(Constants.GUEST_FORM.ID)
            var edit = bundle.getBoolean(Constants.GUEST_FORM.EDITABLE)

            if(id != null && edit != null)
                mID = id
                mEditMode = edit

                setEditIcons(mEditMode)
                mViewModel.getGuest(mID)
        }else{
            setEditIcons(false)
        }

    }

    private fun insertGuest(guest: GuestModel){
        text_title.text = "View Guest"
        form_guest_name.setText(guest.name)
        form_guest_id.setText(guest.cpf)
        form_guest_phone.setText(guest.phone)
        form_guest_zipcode.setText(guest.zipcode)
        form_guest_city.setText(guest.city)
        form_guest_address.setText(guest.address)
        form_guest_age.setText(guest.age)

        when(guest.gender){

            Constants.KEY.FEMALE -> form_guest_female.isChecked = true
            Constants.KEY.MALE -> form_guest_male.isChecked = true
            else -> form_guest_other.isChecked = true

        }

        when(guest.presence){
            Constants.FILTER.PRESENTS -> form_guest_confirm.isChecked = true
            else -> form_guest_dont_confirm.isChecked = true
        }
    }


    private fun setEditIcons(edit : Boolean){
        if(edit){
            editGuest.visibility = View.VISIBLE
            deleteGuest.visibility = View.VISIBLE
        }else{
            editGuest.visibility = View.INVISIBLE
            deleteGuest.visibility = View.INVISIBLE
        }
    }



    private fun checkBoxData(){
        mViewModel.checkGender(form_guest_male,form_guest_female,form_guest_other)
        mViewModel.checkPresence(form_guest_confirm,form_guest_dont_confirm)
    }



    private fun verifyAll(vararg data : EditText){
        for(editText in data){
            multiplexCheck(editText)
        }
    }



    private fun inputListners(vararg data: EditText){

        for(editText in data){
            editText.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    multiplexCheck(editText)
                }

                override fun afterTextChanged(s: Editable?) {}
            })
        }
    }



    private fun multiplexCheck(editText: EditText){
        boxData = editText
        when(editText.id) {
            R.id.form_guest_name -> mViewModel.checkName(editText.text.toString());
            R.id.form_guest_age -> mViewModel.checkAge(editText.text.toString())
            R.id.form_guest_id -> mViewModel.checkCPF(editText.text.toString())
            R.id.form_guest_address -> mViewModel.checkAdress(editText.text.toString())
            R.id.form_guest_city -> mViewModel.checkCity(editText.text.toString())
            R.id.form_guest_zipcode -> mViewModel.checkZipCode(editText.text.toString())
            R.id.form_guest_phone -> mViewModel.checkPhone(editText.text.toString())
        }
    }


}