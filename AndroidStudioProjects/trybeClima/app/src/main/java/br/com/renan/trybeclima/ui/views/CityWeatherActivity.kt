package br.com.renan.trybeclima.ui.views

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.renan.trybeclima.R
import br.com.renan.trybeclima.databinding.ActivityCityWheatherBinding
import br.com.renan.trybeclima.ui.viewmodel.CityWeatherActivityViewModel
import kotlinx.coroutines.launch

class CityWeatherActivity: AppCompatActivity() {
    private lateinit var cityName: String
    private lateinit var binding: ActivityCityWheatherBinding
    private val viewModel: CityWeatherActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_city_wheather)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)
        cityName = intent.getStringExtra("city").toString()

        viewModel.setCityNamePageTitle(cityName)
        binding.cityWeatherBackButton.setOnClickListener { finish() }
        binding.cityTryAgainButton.setOnClickListener { finish() }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.isLoading.collect { if (it == "ok") showWeather() else if(it == "error") showMessageError() }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getWeatherData(cityName)
    }

    private fun showMessageError() {
        binding.cityWeatherProgressIndicator.visibility = View.GONE
        binding.cityErrorMessageLayout.visibility = View.VISIBLE
    }

    private fun showWeather() {
        binding.cityWeatherProgressIndicator.visibility = View.GONE
        binding.cityWeatherLayout.visibility = View.VISIBLE
    }
}