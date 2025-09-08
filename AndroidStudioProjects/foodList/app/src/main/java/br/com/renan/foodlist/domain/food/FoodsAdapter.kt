package br.com.renan.foodlist.domain.food

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.renan.foodlist.R

class FoodsAdapter(private val foodList: List<Food>): Adapter<FoodsAdapter.FoodViewHolder>() {

    class FoodViewHolder(view: View): ViewHolder(view) {
        val foodName: TextView = view.findViewById(R.id.item_food_name)
        val foodCalories: TextView = view.findViewById(R.id.item_food_calories)
        val foodCarbohydrates: TextView = view.findViewById(R.id.item_food_carbohydrates)
        val foodFats: TextView = view.findViewById(R.id.item_food_fats)
        val foodType: TextView = view.findViewById(R.id.item_food_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_card_item, parent, false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int = foodList.size

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val unitMeasurement: Char = 'g'
        val food: Food = foodList[position]

        holder.foodName.text = food.name
        holder.foodType.text = food.type
        holder.foodCalories.text = "${food.calories}$unitMeasurement"
        holder.foodCarbohydrates.text = "${food.carbohydrates}$unitMeasurement"
        holder.foodFats.text = "${food.fats}$unitMeasurement"
    }
}