package com.example.pizzapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pizzapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.buttonSubmit.setOnClickListener{
            var pizzaSizePrice = 0.0
            var toppingsTotal = 0.0

            when {
                binding.radioButton1.isChecked -> pizzaSizePrice = 5.0
                binding.radioButton2.isChecked -> pizzaSizePrice = 7.0
                binding.radioButton3.isChecked -> pizzaSizePrice = 9.0

            }

            if (binding.checkBox1.isChecked){
                toppingsTotal += 1
            }
            if (binding.checkBox2.isChecked){
                toppingsTotal += 2
            }
            if (binding.checkBox3.isChecked){
                toppingsTotal += 3
            }

            binding.textView3.text = "Total Order Price = RM ${pizzaSizePrice + toppingsTotal}"
        }
    }
}