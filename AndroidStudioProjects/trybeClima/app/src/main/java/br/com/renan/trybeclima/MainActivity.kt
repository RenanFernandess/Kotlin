package br.com.renan.trybeclima

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.renan.trybeclima.data.api.OpenWeatherService
import br.com.renan.trybeclima.data.model.CurrentWeatherData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val apiKey = "9908eee11eb702de15900ed1af165a63"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val openWeatherService = OpenWeatherService.instance
        val callOpenWeather = openWeatherService.getCurrentWeatherData("Guidoval", apiKey)

        callOpenWeather.enqueue(object: Callback<CurrentWeatherData> {
            override fun onResponse(
                call: Call<CurrentWeatherData?>,
                response: Response<CurrentWeatherData?>
            ) {
                val weatherData = response.body()
                Log.i("Trybe Clima", "$weatherData")
            }

            override fun onFailure(
                call: Call<CurrentWeatherData?>,
                t: Throwable
            ) {
                Log.e("Clima", "------------ Falhou: ${t.message} ----------------")
            }
        })

    }
}