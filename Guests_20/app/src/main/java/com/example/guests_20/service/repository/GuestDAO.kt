package com.example.guests_20.service.repository

import androidx.room.*
import com.example.guests_20.service.constants.Constants
import com.example.guests_20.service.model.GuestModel


@Dao //camada de acesso aos dados
interface GuestDAO {

    @Insert
    fun save(guest : GuestModel): Long

    @Update
    fun update(guest: GuestModel) : Int

    @Delete
    fun delete(guest: GuestModel)

    @Query("SELECT * FROM ${Constants.GUEST.TABLE_NAME} WHERE id = :id")
    fun get(id: Int): GuestModel


    @Query("SELECT * FROM ${Constants.GUEST.TABLE_NAME} WHERE ${Constants.GUEST.COLUMNS.PRESENCE} = :${Constants.FILTER.ALL}")
    fun getInvited(): List<GuestModel>

    @Query("SELECT * FROM ${Constants.GUEST.TABLE_NAME} WHERE ${Constants.GUEST.COLUMNS.PRESENCE} = :${Constants.FILTER.PRESENTS}")
    fun getPresent(): List<GuestModel>

    @Query("SELECT * FROM ${Constants.GUEST.TABLE_NAME} WHERE ${Constants.GUEST.COLUMNS.PRESENCE} = ${Constants.FILTER.ABSENT}")
    fun getAbsent(): List<GuestModel>




}