package com.example.trabajo_api

import com.google.gson.annotations.SerializedName

data class CoinBasic(
    var id: String,
    var name: String,
    var symbol: String,
    @SerializedName("is_new")var new: Boolean,
    @SerializedName("is_active")var active: Boolean

)