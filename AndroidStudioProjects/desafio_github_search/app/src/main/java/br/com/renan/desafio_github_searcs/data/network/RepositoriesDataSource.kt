package br.com.renan.desafio_github_searcs.data.network

import android.util.Log
import br.com.renan.desafio_github_searcs.data.api.GitHubService
import br.com.renan.desafio_github_searcs.data.models.Repository

class RepositoriesDataSource {
    private val gitHubService = GitHubService.instance

    suspend fun getAllRepositoriesByUser(userName: String): List<Repository>? {
        val repositoriesResponse = gitHubService.getAllRepositoriesByUser(userName)
        Log.i("Error Body ----->", repositoriesResponse.errorBody()?.string().toString())
        return repositoriesResponse.body()
    }
}