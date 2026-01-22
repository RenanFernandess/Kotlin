package br.com.renan.desafio_github_searcs.data.models

import com.google.gson.annotations.SerializedName

data class Repository(
    val name: String,
    val fork: Boolean,
    @SerializedName("html_url")
    val htmlURL: String,
    val homepage: String,
    @SerializedName("languages_url")
    val languagesURL: String,
)