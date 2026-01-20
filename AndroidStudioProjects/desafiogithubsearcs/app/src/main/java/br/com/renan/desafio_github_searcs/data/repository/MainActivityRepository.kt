package br.com.renan.desafio_github_searcs.data.repository

import br.com.renan.desafio_github_searcs.data.models.Repository
import br.com.renan.desafio_github_searcs.data.network.RepositoriesDataSource

class MainActivityRepository {
    private val repositoriesDataSource = RepositoriesDataSource()

    suspend fun getAllRepositoriesByUser(userName: String): List<Repository>? {
        val repositoriesData = repositoriesDataSource.getAllRepositoriesByUser(userName)
        return repositoriesData
    }
}