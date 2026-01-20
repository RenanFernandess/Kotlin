package br.com.renan.desafio_github_searcs.ui.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.renan.desafio_github_searcs.R
import br.com.renan.desafio_github_searcs.data.models.Repository
import br.com.renan.desafio_github_searcs.data.repository.MainActivityRepository
import br.com.renan.desafio_github_searcs.databinding.ActivityMainBinding
import br.com.renan.desafio_github_searcs.ui.adapters.RepositoriesAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val mainActivityRepository = MainActivityRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.repositoriesRecyclerView.layoutManager = LinearLayoutManager(baseContext)

//        Tela de carregamento
//        Salvar o estado do input
//        botão de "X" no input para limpa-lo
//        implmentar o botão de compartilhar
//        ao clicar no repositorio deve abrir em uma aba do navegador
//        Validar o input
//        Implmentar mensagem de erro caso o usuario seja invalido
    }

    override fun onStart() {
        super.onStart()
        binding.searchButton.setOnClickListener {
            val userName = getUserName()

            CoroutineScope(Dispatchers.IO).launch {
                val repositoriesList = mainActivityRepository.getAllRepositoriesByUser(userName)
                repositoriesList?.let {
                    withContext(Dispatchers.Main) {
                        binding.repositoriesRecyclerView.adapter = RepositoriesAdapter(repositoriesList)
                    }
                }
            }

        }
    }

    private fun getUserName(): String {
        val userName = binding.usernameInputText.editText?.text.toString().trim()
        return userName ?: ""
    }
}