package com.example.excuserapp.model


import com.google.gson.annotations.SerializedName

data class ExcuseNetworkEntity(
    @SerializedName("category")
    val category: String,
    @SerializedName("excuse")
    val excuse: String,
    @SerializedName("id")
    val id: Int
)