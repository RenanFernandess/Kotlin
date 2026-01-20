package br.com.renan.desafio_github_searcs.data.models

import com.google.gson.annotations.SerializedName

data class Repository(
    val name: String,
    @SerializedName("html_url")
    val htmlURL: String,
    @SerializedName("languages_url")
    val languagesURL: String,
    val homepage: String
)