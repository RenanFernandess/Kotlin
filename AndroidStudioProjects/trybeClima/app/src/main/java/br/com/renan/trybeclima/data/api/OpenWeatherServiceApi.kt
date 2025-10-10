package br.com.renan.trybeclima.data.api

import br.com.renan.trybeclima.data.model.CurrentWeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherServiceApi {

    @GET("weather")
    suspend fun getCurrentWeatherData(
        @Query("q") cityName: String,
        @Query("appid") apikey: String,
        @Query("units") units:String = "metric"
    ): Response<CurrentWeatherData>
}