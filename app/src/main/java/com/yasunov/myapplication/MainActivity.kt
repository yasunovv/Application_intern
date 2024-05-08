package com.yasunov.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yasunov.myapplication.databinding.ActivityMainBinding
import com.yasunov.myapplication.ui.screens.productList.ProductFragment

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment == null) {
            val fragment = ProductFragment()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment)
                .commit()
        }

    }

    // TODO: Фича с показом информации о продукте
//    override fun onProductCalled(id: Int) {
//
////        val fragment = CrimeFragment.newInstance(id)
////        supportFragmentManager.beginTransaction()
////            .replace(R.id.fragment_container, fragment)
////            .addToBackStack(null)
////            .commit()
//    }

}