package br.com.renan.trybeclima.data.model

data class Weather(
    val cityName: String,
    val temp: String,
    val minTemp: String,
    val maxTemp: String,
    val feelsLike: String,
    val humidity: String
)