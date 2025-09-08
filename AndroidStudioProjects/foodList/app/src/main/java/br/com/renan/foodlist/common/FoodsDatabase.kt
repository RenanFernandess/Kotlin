package br.com.renan.foodlist.common

import br.com.renan.foodlist.domain.food.Food

object FoodsDatabase {
    private val foods: List<Food> = listOf(
        Food(
            name = "Frango (peito sem pele)",
            type = "Carne",
            calories = 165,
            carbohydrates = 0.0,
            proteins = 31.0,
            fats = 3.6,
            fibers = 0.0,
            vitamins = listOf("B3", "B6"),
            minerals = listOf("Fósforo", "Selênio")
        ),
        Food(
            name = "Ovo",
            type = "Laticínio/Proteína",
            calories = 155,
            carbohydrates = 1.1,
            proteins = 13.0,
            fats = 11.0,
            fibers = 0.0,
            vitamins = listOf("A", "D", "B12"),
            minerals = listOf("Ferro", "Selênio")
        ),
        Food(
            name = "Arroz Integral",
            type = "Grão",
            calories = 111,
            carbohydrates = 23.0,
            proteins = 2.6,
            fats = 0.9,
            fibers = 1.8,
            vitamins = listOf("B1", "B6"),
            minerals = listOf("Manganês", "Magnésio")
        ),
        Food(
            name = "Salmão",
            type = "Peixe",
            calories = 208,
            carbohydrates = 0.0,
            proteins = 20.0,
            fats = 13.0,
            fibers = 0.0,
            vitamins = listOf("D", "B12"),
            minerals = listOf("Selênio", "Potássio")
        ),
        Food(
            name = "Brócolis",
            type = "Vegetal",
            calories = 34,
            carbohydrates = 6.6,
            proteins = 2.8,
            fats = 0.4,
            fibers = 2.6,
            vitamins = listOf("C", "K"),
            minerals = listOf("Ferro", "Potássio")
        ),
        Food(
            name = "Feijão Preto",
            type = "Leguminosa",
            calories = 341,
            carbohydrates = 62.0,
            proteins = 21.0,
            fats = 1.4,
            fibers = 15.0,
            vitamins = listOf("B1", "B9"),
            minerals = listOf("Ferro", "Magnésio")
        ),
        Food(
            name = "Leite Integral",
            type = "Laticínio",
            calories = 61,
            carbohydrates = 4.7,
            proteins = 3.2,
            fats = 3.3,
            fibers = 0.0,
            vitamins = listOf("D", "B12"),
            minerals = listOf("Cálcio", "Fósforo")
        ),
        Food(
            name = "Batata Doce",
            type = "Tubérculo",
            calories = 86,
            carbohydrates = 20.1,
            proteins = 1.6,
            fats = 0.1,
            fibers = 3.0,
            vitamins = listOf("A", "C"),
            minerals = listOf("Potássio", "Manganês")
        ),
        Food(
            name = "Aveia",
            type = "Grão",
            calories = 389,
            carbohydrates = 66.3,
            proteins = 16.9,
            fats = 6.9,
            fibers = 10.6,
            vitamins = listOf("B1", "B5"),
            minerals = listOf("Manganês", "Fósforo")
        ),
        Food(
            name = "Carne Moída (patinho)",
            type = "Carne",
            calories = 250,
            carbohydrates = 0.0,
            proteins = 26.0,
            fats = 17.0,
            fibers = 0.0,
            vitamins = listOf("B12", "Ferro"),
            minerals = listOf("Zinco", "Ferro")
        ),
        Food(
            name = "Espinafre",
            type = "Vegetal",
            calories = 23,
            carbohydrates = 3.6,
            proteins = 2.9,
            fats = 0.4,
            fibers = 2.2,
            vitamins = listOf("A", "K"),
            minerals = listOf("Ferro", "Cálcio")
        ),
        Food(
            name = "Grão de Bico",
            type = "Leguminosa",
            calories = 164,
            carbohydrates = 27.4,
            proteins = 8.9,
            fats = 2.6,
            fibers = 7.6,
            vitamins = listOf("B9", "B6"),
            minerals = listOf("Manganês", "Ferro")
        ),
        Food(
            name = "Iogurte Natural Integral",
            type = "Laticínio",
            calories = 61,
            carbohydrates = 4.7,
            proteins = 3.5,
            fats = 3.3,
            fibers = 0.0,
            vitamins = listOf("B12"),
            minerals = listOf("Cálcio", "Fósforo")
        ),
        Food(
            name = "Cenoura",
            type = "Vegetal",
            calories = 41,
            carbohydrates = 9.6,
            proteins = 0.9,
            fats = 0.2,
            fibers = 2.8,
            vitamins = listOf("A", "K"),
            minerals = listOf("Potássio", "Biotina")
        ),
        Food(
            name = "Quinoa",
            type = "Grão",
            calories = 120,
            carbohydrates = 21.3,
            proteins = 4.4,
            fats = 1.9,
            fibers = 2.8,
            vitamins = listOf("B2", "B6"),
            minerals = listOf("Manganês", "Magnésio")
        ),
        Food(
            name = "Atum em lata (água)",
            type = "Peixe",
            calories = 116,
            carbohydrates = 0.0,
            proteins = 25.5,
            fats = 0.8,
            fibers = 0.0,
            vitamins = listOf("B3", "B12"),
            minerals = listOf("Selênio", "Sódio")
        ),
        Food(
            name = "Amêndoas",
            type = "Semente/Fruto Seco",
            calories = 579,
            carbohydrates = 21.6,
            proteins = 21.2,
            fats = 49.9,
            fibers = 12.2,
            vitamins = listOf("E", "B2"),
            minerals = listOf("Magnésio", "Manganês")
        ),
        Food(
            name = "Lentilha",
            type = "Leguminosa",
            calories = 116,
            carbohydrates = 20.1,
            proteins = 9.0,
            fats = 0.4,
            fibers = 7.9,
            vitamins = listOf("B9", "B1"),
            minerals = listOf("Ferro", "Manganês")
        ),
        Food(
            name = "Queijo Cottage",
            type = "Laticínio",
            calories = 98,
            carbohydrates = 3.4,
            proteins = 11.0,
            fats = 4.3,
            fibers = 0.0,
            vitamins = listOf("B12"),
            minerals = listOf("Cálcio", "Fósforo")
        ),
        Food(
            name = "Pão Integral",
            type = "Grão",
            calories = 247,
            carbohydrates = 42.0,
            proteins = 13.0,
            fats = 3.6,
            fibers = 7.0,
            vitamins = listOf("B1", "B3"),
            minerals = listOf("Ferro", "Magnésio")
        )
    )

    fun findAll(): List<Food> = foods
}