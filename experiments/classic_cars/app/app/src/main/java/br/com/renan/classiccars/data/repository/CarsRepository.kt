package br.com.renan.classiccars.data.repository

import br.com.renan.classiccars.data.api.database.LocalDataDbHelper

class ClassicCarsRepository(
    private var _dbHelper: LocalDataDbHelper? = null
) {
    private val dbHelper get() = _dbHelper!!

    fun favoriteCar(carId: Int) {}

    fun findCarById(carId: Int) {}
}