package com.example.api_teste

import com.example.api_teste.Constants.Constants_URL
import com.google.gson.annotations.SerializedName

class PostModel {

    @SerializedName("id")
    var id : Int = 0

    @SerializedName("userId")
    var userId : Int = 0

    @SerializedName("title")
    var title : String = ""

    @SerializedName("body")
    var body : String = ""



}