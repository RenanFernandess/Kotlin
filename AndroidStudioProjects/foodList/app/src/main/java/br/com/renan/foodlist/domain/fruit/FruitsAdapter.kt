package br.com.renan.foodlist.domain.fruit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.renan.foodlist.R

class FruitsAdapter(
    private val fruits: List<Fruit>
): Adapter<FruitsAdapter.FruitsViewHolder>() {

    class FruitsViewHolder(view: View): ViewHolder(view) {
        val fruitName: TextView = view.findViewById(R.id.item_fruit_name)
        val fruitCalories: TextView = view.findViewById(R.id.item_fruit_calories)
        val fruitCarbohydrates: TextView = view.findViewById(R.id.item_fruit_carbohydrates)
        val fruitFats: TextView = view.findViewById(R.id.item_fruit_fats)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_card_item, parent, false)
        return FruitsViewHolder(view)
    }

    override fun getItemCount(): Int = fruits.size

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        val unitMeasurement: Char = 'g'
        val fruit: Fruit = fruits[position]

        holder.fruitName.text = fruit.name
        holder.fruitCalories.text = "${fruit.calories_per_100g}$unitMeasurement"
        holder.fruitCarbohydrates.text = "${fruit.carbohydrates}$unitMeasurement"
        holder.fruitFats.text = "${fruit.fats}$unitMeasurement"
    }
}