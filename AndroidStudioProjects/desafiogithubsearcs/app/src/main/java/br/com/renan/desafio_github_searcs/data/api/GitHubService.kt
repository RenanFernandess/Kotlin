package br.com.renan.desafio_github_searcs.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitHubService {
    private const val BASE_URL = "https://api.github.com/"

    val instance: GitHubServiceApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(GitHubServiceApi::class.java)
    }
}