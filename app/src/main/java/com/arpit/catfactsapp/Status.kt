package com.arpit.catfactsapp

import com.google.gson.annotations.SerializedName

data class Status(

    @field:SerializedName("verified")
    val verified: Boolean? = null,

    @field:SerializedName("sentCount")
    val sentCount: Int? = null
)
