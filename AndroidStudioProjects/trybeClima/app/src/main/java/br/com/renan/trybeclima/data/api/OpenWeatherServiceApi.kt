package br.com.renan.trybeclima.data.api

import br.com.renan.trybeclima.data.model.CurrentWeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherServiceApi {

    @GET("weather")
    fun getCurrentWeatherData(
        @Query("q") cityName: String,
        @Query("appid") apikey: String,
        @Query("units") units:String = "metric"
    ): Call<CurrentWeatherData>
}