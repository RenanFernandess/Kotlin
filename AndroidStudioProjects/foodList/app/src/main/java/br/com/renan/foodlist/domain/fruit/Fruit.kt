package br.com.renan.foodlist.domain.fruit

data class Fruit(
    val name: String,
    val calories_per_100g: Int,
    val carbohydrates: Double,
    val proteins: Double,
    val fats: Double,
    val fibers: Double,
    val vitamins: List<String>,
    val minerals: List<String>
)
