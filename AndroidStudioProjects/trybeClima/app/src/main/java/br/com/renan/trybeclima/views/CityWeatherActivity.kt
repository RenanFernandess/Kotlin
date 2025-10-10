package br.com.renan.trybeclima.views

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.renan.trybeclima.R
import br.com.renan.trybeclima.data.api.OpenWeatherService
import com.google.android.material.progressindicator.CircularProgressIndicator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CityWeatherActivity: AppCompatActivity() {
    private val apiKey = "9908eee11eb702de15900ed1af165a63"
    private val openWeatherService = OpenWeatherService.instance

    private val cityWeatherLayout: ConstraintLayout by lazy { findViewById(R.id.city_weather_layout) }
    private val progressIndicator: CircularProgressIndicator by lazy { findViewById(R.id.city_weather_progress_indicator) }
    private val backButton: Button by lazy { findViewById(R.id.city_weather_back_button) }
    private val pageTitle: TextView by lazy { findViewById(R.id.city_weather_title) }

    private val cityName: TextView by lazy { findViewById(R.id.city_name) }
    private val cityTemp: TextView by lazy { findViewById(R.id.city_temp) }
    private val cityMinTemp: TextView by lazy { findViewById(R.id.city_min_temp) }
    private val cityMaxTemp: TextView by lazy { findViewById(R.id.city_max_temp) }
    private val cityFeelsTemp: TextView by lazy { findViewById(R.id.city_feels_temp) }
    private val cityHumidity: TextView by lazy { findViewById(R.id.city_humidity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_wheather)

        val city: String = intent.getStringExtra("city").toString()

        pageTitle.text = "Clima em $city"

        backButton.setOnClickListener {
            finish()
        }

        getCityWeather(city)
    }

    private fun getCityWeather(city: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val responseCurrentWeatherData = openWeatherService.getCurrentWeatherData(city, apiKey)
            val currentWeatherData = responseCurrentWeatherData.body()

            if (currentWeatherData != null) {
                withContext(Dispatchers.Main) {
                    finishLoading()
                    fillWeatherFields(
                        currentWeatherData.name,
                        "${currentWeatherData.main.temp}°C",
                        "${currentWeatherData.main.tempMin}°C",
                        "${currentWeatherData.main.tempMax}°C",
                        "${currentWeatherData.main.feelsLike}°C",
                        "${currentWeatherData.main.humidity}%"
                    )
                }
            }
        }
    }

    private fun finishLoading() {
        progressIndicator.visibility = View.GONE
        cityWeatherLayout.visibility = View.VISIBLE
    }

    private fun fillWeatherFields(
        name: String,
        temp: String,
        minTemp: String,
        maxTemp: String,
        feelsTemp: String,
        humidity: String,
    ) {
        cityName.text = name
        cityTemp.text = temp
        cityMinTemp.text = minTemp
        cityMaxTemp.text = maxTemp
        cityFeelsTemp.text = feelsTemp
        cityHumidity.text = humidity
    }
}