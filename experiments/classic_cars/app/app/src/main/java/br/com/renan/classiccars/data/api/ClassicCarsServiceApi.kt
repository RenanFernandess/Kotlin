package br.com.renan.classiccars.data.api

import br.com.renan.classiccars.data.models.Car
import retrofit2.Response
import retrofit2.http.GET

interface ClassicCarsServiceApi {

    @GET("cars")
    suspend fun getCars(): Response<List<Car>>
}