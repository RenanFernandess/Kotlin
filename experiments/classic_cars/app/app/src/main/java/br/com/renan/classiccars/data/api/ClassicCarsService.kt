package br.com.renan.classiccars.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClassicCarsService {
    private const val BASE_URL: String = "http://192.168.1.9:8080"

    val instance: ClassicCarsServiceApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ClassicCarsServiceApi::class.java)
    }
}