package com.example.guests_20.service.repository

import android.content.Context
import com.example.guests_20.service.model.GuestModel
import java.lang.Exception

class GuestRepository(context: Context){


    private val mGuestDatabase = GuestDatabase.getDatabase(context).guestDAO()


    fun getAll(): List<GuestModel> {

        return try {
            return mGuestDatabase.getInvited()
        }catch (e: Exception){
            emptyList()
        }
    }

    fun getPresents(): List<GuestModel>{
        return try {
            return mGuestDatabase.getPresent()
        }catch (e: Exception){
            emptyList()
        }
    }

    fun getAbsents(): List<GuestModel>{

        return try {
            return mGuestDatabase.getAbsent()
        }catch (e: Exception){
            emptyList()
        }

    }

    fun createGuest(guest: GuestModel): Boolean{
        return try{
            mGuestDatabase.save(guest)
            true
        }catch (e : Exception){
            false
        }
    }

    fun readGuest(id: Int): GuestModel?{
        return try{
            return mGuestDatabase.get(id)
        }catch (e : Exception){
            null
        }
    }

    fun updateGuest(guest: GuestModel): Boolean{

        return try{
            mGuestDatabase.update(guest)
            true
        }catch (e : Exception){
            false
        }

    }

    fun deleteGuest(guest: GuestModel): Boolean{

        return try{
            mGuestDatabase.delete(guest)
            true
        }catch (e : Exception){
            false
        }

    }



}