package br.com.renan.desafio_github_searcs.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.renan.desafio_github_searcs.data.models.Repository
import br.com.renan.desafio_github_searcs.databinding.ListItemBinding
import br.com.renan.desafio_github_searcs.data.models.RepositoryItemListener

class RepositoriesAdapter(
    private val repositoriesList: List<Repository>,
    private val repositoryItemListener: RepositoryItemListener
): RecyclerView.Adapter<RepositoriesAdapter.RepositoriesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoriesViewHolder {
        val binding = ListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RepositoriesViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RepositoriesViewHolder,
        position: Int
    ) {
        val repository = repositoriesList[position]
        holder.binding.run {
            repositoryName.text = repository.name
            shareButton.setOnClickListener {
                repositoryItemListener.shareRepository(repository.homepage)
            }
        }
    }

    override fun getItemCount(): Int = repositoriesList.size

    class RepositoriesViewHolder(val binding: ListItemBinding):
        RecyclerView.ViewHolder(binding.root) {}
}