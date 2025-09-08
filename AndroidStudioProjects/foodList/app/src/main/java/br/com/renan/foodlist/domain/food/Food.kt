package br.com.renan.foodlist.domain.food

data class Food(
    val name: String,
    val type: String,
    val calories: Int,
    val carbohydrates: Double,
    val proteins: Double,
    val fats: Double,
    val fibers: Double,
    val vitamins: List<String>,
    val minerals: List<String>
)
