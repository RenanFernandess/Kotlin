package br.com.renan.trybeclima.data.model

import com.google.gson.annotations.SerializedName

data class RainData (
    @SerializedName("1h")
    val oneHour: Double
)
