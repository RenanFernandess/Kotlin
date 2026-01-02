package br.com.renan.classiccars.data.models

data class Car(
    val id: Int,
    val manufacture: String,
    val model: String,
    val year: Int,
    val country: String,
    val style: String
)