package br.com.renan.trybeclima.views

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.renan.trybeclima.R
import br.com.renan.trybeclima.databinding.ActivityCityWheatherBinding
import br.com.renan.trybeclima.viewmodel.CityWeatherActivityViewModel

class CityWeatherActivity: AppCompatActivity() {
    private lateinit var city: String
    private lateinit var binding: ActivityCityWheatherBinding
    private val viewModel: CityWeatherActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_city_wheather)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)


        city = intent.getStringExtra("city").toString()
        binding.cityWeatherTitle.text = "Clima em $city"
        binding.cityWeatherBackButton.setOnClickListener { finish() }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getWeatherData(city)
        viewModel.isLoading.observe(this) { if (!it) finishLoading() }
    }

    private fun finishLoading() {
        binding.cityWeatherProgressIndicator.visibility = View.GONE
        binding.cityWeatherLayout.visibility = View.VISIBLE
    }
}