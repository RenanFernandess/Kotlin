package br.com.renan.trybeclima.data.repository

import br.com.renan.trybeclima.data.model.Weather
import br.com.renan.trybeclima.data.network.WeatherDataSource

class WeatherRepository {
    private val weatherDataSource = WeatherDataSource()

    suspend fun getWeather(cityName: String): Weather? {
        val currentWeatherData = weatherDataSource.getCurrentWeatherData(cityName)
        return if (currentWeatherData != null) Weather(
            currentWeatherData.name,
            "${currentWeatherData.main.temp} °C",
            "${currentWeatherData.main.tempMin} °C",
            "${currentWeatherData.main.tempMax} °C",
            "${currentWeatherData.main.feelsLike} °C",
            "${currentWeatherData.main.humidity}%"
        ) else null
    }
}