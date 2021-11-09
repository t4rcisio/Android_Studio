package com.example.guests_20.service.constants

import android.accessibilityservice.AccessibilityGestureEvent
import android.provider.ContactsContract

class Constants private constructor(){

    object KEY{
        val MALE = "MALE"
        val FEMALE = "FEMALE"
        val OTHER = "OTHER"
    }


    object GUEST{
        const val TABLE_NAME = "Guest"

        object COLUMNS{
            const val ID = "id"
            const val NAME = "name"
            const val GENDER = "gender"
            const val AGE = "age"
            const val CPF = "cpf"
            const val ADDRESS = "address"
            const val CITY = "city"
            const val ZIPCODE = "zipcode"
            const val PHONE = "phone"
            const val PRESENCE = "presence"
        }
    }

    object GUEST_FORM{
        const val EDITABLE = "EDITABLE"
        const val ID = "ID"
    }

    object FILTER{
        const val ALL = "ALL"
        const val PRESENTS = "PRESENTS"
        const val ABSENT = "ABSENT"
    }
}