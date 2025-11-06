package br.com.renan.trybeclima.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.renan.trybeclima.R
import br.com.renan.trybeclima.data.repository.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CityWeatherActivityViewModel: ViewModel() {
    private val weatherRepository = WeatherRepository()

    private var _cityNamePageTitle = MutableLiveData("")
    val cityNamePageTitle: LiveData<String>
        get() = _cityNamePageTitle

    private var _requestStatus = MutableStateFlow("")
    val isLoading: StateFlow<String>
        get() = _requestStatus

    private var _cityName = MutableLiveData("")
    val cityName: LiveData<String>
        get() = _cityName

    private var _cityTemp = MutableLiveData("0 °C")
    val cityTemp: LiveData<String>
        get() = _cityTemp

    private var _cityMinTemp = MutableLiveData("0 °C")
    val cityMinTem: LiveData<String>
        get() = _cityMinTemp

    private var _cityMaxTemp = MutableLiveData("0 °C")
    val cityMaxTemp: LiveData<String>
        get() = _cityMaxTemp

    private var _cityFeelsTemp = MutableLiveData("0 °C")
    val cityFeelsTemp: LiveData<String>
        get() = _cityFeelsTemp

    private var _cityHumidity = MutableLiveData("0%")
    val cityHumidity: LiveData<String>
        get() = _cityHumidity

    fun getWeatherData(cityName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val weather = weatherRepository.getWeather(cityName)
            if (weather != null) {
                _cityName.postValue(weather.cityName)
                _cityTemp.postValue(weather.temp)
                _cityMinTemp.postValue(weather.minTemp)
                _cityMaxTemp.postValue(weather.maxTemp)
                _cityFeelsTemp.postValue(weather.feelsLike)
                _cityHumidity.postValue(weather.humidity)
                setRequestStatus("ok")
            } else setRequestStatus("error")
        }
    }

    private fun setRequestStatus(status: String) {
        _requestStatus.value = status
    }

    fun setCityNamePageTitle(cityName: String) {
        _cityNamePageTitle.postValue(cityName)
    }
}