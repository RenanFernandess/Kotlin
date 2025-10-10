package br.com.renan.trybeclima.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.com.renan.trybeclima.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private val cityNameInput: TextInputEditText by lazy { findViewById(R.id.main_input_city_name) }
    private val cityNameFieldInput: TextInputLayout by lazy { findViewById(R.id.main_field_Input_city_name) }
    private val searchCityButton: Button by lazy { findViewById(R.id.main_search_city_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        searchCityButton.setOnClickListener {
            val city: String = cityNameInput.text.toString().trim()
            if (!city.isEmpty()) {
                val it = Intent(baseContext, CityWeatherActivity::class.java)
                it.putExtra("city", city)
                startActivity(it)
            } else {
                cityNameFieldInput.error = "Digite o nome da cidade antes de continuar!"
            }
        }

    }
}