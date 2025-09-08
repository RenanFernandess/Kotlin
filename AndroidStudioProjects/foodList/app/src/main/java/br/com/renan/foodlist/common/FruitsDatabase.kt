package br.com.renan.foodlist.common

import br.com.renan.foodlist.domain.fruit.Fruit

object FruitsDatabase {
    private val fruits: List<Fruit> = listOf(
        Fruit(
            name = "Maçã",
            calories_per_100g = 52,
            carbohydrates = 13.8,
            proteins = 0.3,
            fats = 0.2,
            fibers = 2.4,
            vitamins = listOf("C", "K"),
            minerals = listOf("Potássio")
        ),
        Fruit(
            name = "Banana",
            calories_per_100g = 89,
            carbohydrates = 22.8,
            proteins = 1.1,
            fats = 0.3,
            fibers = 2.6,
            vitamins = listOf("B6", "C"),
            minerals = listOf("Potássio", "Manganês")
        ),
        Fruit(
            name = "Laranja",
            calories_per_100g = 47,
            carbohydrates = 11.8,
            proteins = 0.9,
            fats = 0.1,
            fibers = 2.4,
            vitamins = listOf("C"),
            minerals = listOf("Potássio", "Cálcio")
        ),
        Fruit(
            name = "Morango",
            calories_per_100g = 32,
            carbohydrates = 7.7,
            proteins = 0.7,
            fats = 0.3,
            fibers = 2.0,
            vitamins = listOf("C", "K"),
            minerals = listOf("Manganês")
        ),
        Fruit(
            name = "Uva",
            calories_per_100g = 69,
            carbohydrates = 18.1,
            proteins = 0.7,
            fats = 0.2,
            fibers = 0.9,
            vitamins = listOf("C", "K"),
            minerals = listOf("Cobre")
        ),
        Fruit(
            name = "Abacaxi",
            calories_per_100g = 50,
            carbohydrates = 13.1,
            proteins = 0.5,
            fats = 0.1,
            fibers = 1.4,
            vitamins = listOf("C", "B6"),
            minerals = listOf("Manganês")
        ),
        Fruit(
            name = "Manga",
            calories_per_100g = 60,
            carbohydrates = 15.0,
            proteins = 0.8,
            fats = 0.4,
            fibers = 1.6,
            vitamins = listOf("A", "C"),
            minerals = listOf("Potássio")
        ),
        Fruit(
            name = "Kiwi",
            calories_per_100g = 61,
            carbohydrates = 14.7,
            proteins = 1.1,
            fats = 0.5,
            fibers = 3.0,
            vitamins = listOf("C", "K", "E"),
            minerals = listOf("Potássio")
        ),
        Fruit(
            name = "Pera",
            calories_per_100g = 57,
            carbohydrates = 15.2,
            proteins = 0.4,
            fats = 0.1,
            fibers = 3.1,
            vitamins = listOf("C", "K"),
            minerals = listOf("Cobre")
        ),
        Fruit(
            name = "Cereja",
            calories_per_100g = 50,
            carbohydrates = 12.4,
            proteins = 1.0,
            fats = 0.3,
            fibers = 2.1,
            vitamins = listOf("C", "A"),
            minerals = listOf("Potássio")
        ),
        Fruit(
            name = "Melancia",
            calories_per_100g = 30,
            carbohydrates = 7.6,
            proteins = 0.6,
            fats = 0.2,
            fibers = 0.4,
            vitamins = listOf("C", "A"),
            minerals = listOf("Potássio")
        ),
        Fruit(
            name = "Pêssego",
            calories_per_100g = 39,
            carbohydrates = 9.5,
            proteins = 0.9,
            fats = 0.3,
            fibers = 1.5,
            vitamins = listOf("C", "A"),
            minerals = listOf("Potássio")
        ),
        Fruit(
            name = "Amora",
            calories_per_100g = 43,
            carbohydrates = 9.6,
            proteins = 1.4,
            fats = 0.5,
            fibers = 5.3,
            vitamins = listOf("C", "K"),
            minerals = listOf("Manganês")
        ),
        Fruit(
            name = "Limão",
            calories_per_100g = 29,
            carbohydrates = 9.3,
            proteins = 1.1,
            fats = 0.3,
            fibers = 2.8,
            vitamins = listOf("C"),
            minerals = listOf("Potássio")
        ),
        Fruit(
            name = "Mamão",
            calories_per_100g = 43,
            carbohydrates = 10.8,
            proteins = 0.5,
            fats = 0.3,
            fibers = 1.7,
            vitamins = listOf("C", "A"),
            minerals = listOf("Potássio")
        ),
        Fruit(
            name = "Melão",
            calories_per_100g = 34,
            carbohydrates = 8.2,
            proteins = 0.8,
            fats = 0.2,
            fibers = 0.9,
            vitamins = listOf("A", "C"),
            minerals = listOf("Potássio")
        ),
        Fruit(
            name = "Figo",
            calories_per_100g = 74,
            carbohydrates = 19.2,
            proteins = 0.8,
            fats = 0.3,
            fibers = 2.9,
            vitamins = listOf("K", "B6"),
            minerals = listOf("Manganês", "Potássio")
        ),
        Fruit(
            name = "Ameixa",
            calories_per_100g = 46,
            carbohydrates = 11.4,
            proteins = 0.7,
            fats = 0.3,
            fibers = 1.4,
            vitamins = listOf("C", "K"),
            minerals = listOf("Potássio")
        ),
        Fruit(
            name = "Goiaba",
            calories_per_100g = 68,
            carbohydrates = 14.3,
            proteins = 2.6,
            fats = 1.0,
            fibers = 5.4,
            vitamins = listOf("C", "A"),
            minerals = listOf("Potássio")
        ),
        Fruit(
            name = "Abacate",
            calories_per_100g = 160,
            carbohydrates = 8.5,
            proteins = 2.0,
            fats = 14.7,
            fibers = 6.7,
            vitamins = listOf("K", "C", "E", "B6"),
            minerals = listOf("Potássio", "Cobre")
        )
    )

    fun findAll(): List<Fruit> = fruits
}