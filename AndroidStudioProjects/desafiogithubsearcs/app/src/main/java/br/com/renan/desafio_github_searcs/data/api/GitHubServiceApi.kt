package br.com.renan.desafio_github_searcs.data.api

import br.com.renan.desafio_github_searcs.data.models.Repository
import retrofit2.Response
import retrofit2.http.Path
import retrofit2.http.GET

interface GitHubServiceApi {
    @GET("users/{user}/repos")
    suspend fun getAllRepositoriesByUser(@Path("user") user: String): Response<List<Repository>>
}