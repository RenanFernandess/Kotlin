package br.com.renan.classiccars.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.renan.classiccars.R
import br.com.renan.classiccars.data.api.ClassicCarsService
import br.com.renan.classiccars.data.models.Car
import br.com.renan.classiccars.databinding.ActivityMainBinding
import br.com.renan.classiccars.ui.adapters.CarsAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val classicCarsApi = ClassicCarsService.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val response = classicCarsApi.getCars()
            val cars: List<Car>? = response.body()

            withContext(Dispatchers.Main) {
                if (cars !== null) {
                    binding.carsRecyvlerVeiw.layoutManager = LinearLayoutManager(baseContext)
                    binding.carsRecyvlerVeiw.adapter = CarsAdapter(cars)
                }
            }
        }
    }
}