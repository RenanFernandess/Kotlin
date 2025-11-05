package br.com.renan.trybeclima.ui.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.renan.trybeclima.R
import br.com.renan.trybeclima.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainSearchCityButton.setOnClickListener {
            val cityName: String = binding.mainInputCityName.text.toString().trim()
            if (!cityName.isEmpty()) {
                val it = Intent(baseContext, CityWeatherActivity::class.java)
                it.putExtra("city", cityName)
                startActivity(it)
            } else {
                binding.mainFieldInputCityName.error = getString(R.string.main_field_input_city_name_error)
            }
        }

    }
}