package br.com.renan.desafio_github_searcs.ui.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.renan.desafio_github_searcs.R
import br.com.renan.desafio_github_searcs.data.repository.MainActivityRepository
import br.com.renan.desafio_github_searcs.databinding.ActivityMainBinding
import br.com.renan.desafio_github_searcs.ui.adapters.RepositoriesAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.core.content.edit
import br.com.renan.desafio_github_searcs.data.models.RepositoryItemListener
import androidx.core.net.toUri

class MainActivity : AppCompatActivity(), RepositoryItemListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val mainActivityRepository = MainActivityRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.repositoriesRecyclerView.layoutManager = LinearLayoutManager(baseContext)

        val userName = getSavedUserName()
        if (userName != null) {
            binding.usernameInputText.editText?.setText(userName)
            requestRepositories(userName)
        }

//        Implmentar mensagem de erro caso o usuario seja invalido
    }

    override fun onStart() {
        super.onStart()
        binding.searchButton.setOnClickListener {
            val userName = getUserName()
            if(userName != null) requestRepositories(userName)
        }
    }

    private fun getUserName(): String? = binding.usernameInputText.run {
        val userName = editText?.text.toString().trim()
        if (userName.isBlank()) {
            error = "O nome de usuário deve haver pelomenos 1 caractere"
            null
        } else {
            error = ""
            userName
        }
    }

    private fun requestRepositories(userName: String) {
        binding.resultTextViewMessage.visibility = View.GONE
        binding.repositoriesRecyclerView.visibility = View.GONE
        binding.circularProgressIndicator.visibility = View.VISIBLE

        CoroutineScope(Dispatchers.IO).launch {
            val repositoriesList = mainActivityRepository.getAllRepositoriesByUser(userName)
            repositoriesList?.let {
                withContext(Dispatchers.Main) {
                    binding.repositoriesRecyclerView.adapter = RepositoriesAdapter(repositoriesList, this@MainActivity)
                    binding.resultTextViewMessage.visibility = View.VISIBLE
                    binding.repositoriesRecyclerView.visibility = View.VISIBLE
                    binding.circularProgressIndicator.visibility = View.GONE
                    saveUserName(userName)
                }
            }
        }
    }

    private fun saveUserName(userName: String) {
        getPreferences(MODE_PRIVATE).edit {
            putString(getString(R.string.user_name_preferences_key), userName)
        }
    }

    private fun getSavedUserName(): String? = getPreferences(MODE_PRIVATE).getString(getString(R.string.user_name_preferences_key), "")

    override fun shareRepository(repositoryUrl: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, repositoryUrl)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    override fun openWebPage(url: String) {
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, url.toUri())
        startActivity(webIntent)
    }

}