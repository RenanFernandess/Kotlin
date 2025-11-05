package br.com.renan.trybeclima.data.network

import br.com.renan.trybeclima.data.api.OpenWeatherService
import br.com.renan.trybeclima.data.model.CurrentWeatherData

class WeatherDataSource {
    private val apiKey = "9908eee11eb702de15900ed1af165a63"
    private val openWeatherService = OpenWeatherService.instance

    suspend fun getCurrentWeatherData(cityName: String): CurrentWeatherData? {
        val responseCurrentWeatherData = openWeatherService.getCurrentWeatherData(cityName, apiKey)
        return responseCurrentWeatherData.body()
    }
}