package com.example.guests_20.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.guests_20.service.constants.Constants


@Entity(tableName = Constants.GUEST.TABLE_NAME)
 class GuestModel{


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "name")
     var name: String = ""

    @ColumnInfo(name = "gender")
     var gender: String = ""

    @ColumnInfo(name = "age")
     var age: String = ""

    @ColumnInfo(name = "cpf")
     var cpf: String = ""

    @ColumnInfo(name = "address")
     var address: String = ""

    @ColumnInfo(name = "city")
     var city: String = ""

    @ColumnInfo(name = "zipcode")
     var zipcode: String = ""

    @ColumnInfo(name = "phone")
     var phone: String = ""

    @ColumnInfo(name = "presence")
     var presence: String = ""

 }