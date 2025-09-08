package br.com.renan.foodlist.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.renan.foodlist.R
import br.com.renan.foodlist.fragments.FoodsFragment
import br.com.renan.foodlist.fragments.FruitsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val bottomNavigation: BottomNavigationView by lazy { findViewById(R.id.main_bottom_navigation) }
    private val fruitsFragment = FruitsFragment()
    private val foodsFragment = FoodsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment(fruitsFragment)

        bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.bottom_navigation_foods -> showFragment(foodsFragment)
                R.id.bottom_navigation_fruits -> showFragment(fruitsFragment)
            }
            true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, fragment).commit()
    }
}