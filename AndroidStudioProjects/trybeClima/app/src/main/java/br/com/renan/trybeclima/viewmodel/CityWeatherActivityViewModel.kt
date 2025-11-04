package br.com.renan.trybeclima.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.renan.trybeclima.data.api.OpenWeatherService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CityWeatherActivityViewModel: ViewModel() {
    private val apiKey = "9908eee11eb702de15900ed1af165a63"
    private val openWeatherService = OpenWeatherService.instance

    private var _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private var _cityName = MutableLiveData("")
    val cityName: LiveData<String>
        get() = _cityName

    private var _cityTemp = MutableLiveData("0°C")
    val cityTemp: LiveData<String>
        get() = _cityTemp

    private var _cityMinTemp = MutableLiveData("0°C")
    val cityMinTem: LiveData<String>
        get() = _cityMinTemp

    private var _cityMaxTemp = MutableLiveData("0°C")
    val cityMaxTemp: LiveData<String>
        get() = _cityMaxTemp

    private var _cityFeelsTemp = MutableLiveData("0°C")
    val cityFeelsTemp: LiveData<String>
        get() = _cityFeelsTemp

    private var _cityHumidity = MutableLiveData("0%")
    val cityHumidity: LiveData<String>
        get() = _cityHumidity

    fun getWeatherData(city: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val responseCurrentWeatherData = openWeatherService.getCurrentWeatherData(city, apiKey)
            val currentWeatherData = responseCurrentWeatherData.body()

            if (currentWeatherData != null) {
                _cityName.postValue(currentWeatherData.name)
                _cityTemp.postValue("${currentWeatherData.main.temp}°C")
                _cityMinTemp.postValue("${currentWeatherData.main.tempMin}°C")
                _cityMaxTemp.postValue("${currentWeatherData.main.tempMax}°C")
                _cityFeelsTemp.postValue("${currentWeatherData.main.feelsLike}°C")
                _cityHumidity.postValue("${currentWeatherData.main.humidity}%")
                _isLoading.postValue(false)
            }
        }
    }
}