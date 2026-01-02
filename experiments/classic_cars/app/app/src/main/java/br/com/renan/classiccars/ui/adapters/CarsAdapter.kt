package br.com.renan.classiccars.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.renan.classiccars.data.models.Car
import br.com.renan.classiccars.databinding.ListCarsItemBinding

class CarsAdapter(
    private val carsList: List<Car>
): RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {

    class CarsViewHolder(val binding: ListCarsItemBinding): RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CarsViewHolder {
        val binding = ListCarsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CarsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CarsViewHolder,
        position: Int
    ) {
        val car = carsList[position]

        holder.binding.run {
            cardCarName.text = "${car.manufacture} ${car.model} ${car.year}"
            cardCarStyle.text = car.style
        }
    }

    override fun getItemCount(): Int = carsList.size
}