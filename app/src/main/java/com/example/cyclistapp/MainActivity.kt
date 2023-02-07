package com.example.cyclistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import com.example.cyclistapp.databinding.ActivityMainBinding
import com.example.cyclistapp.model.Cyclist
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels.toFloat()
        val runner1 = Cyclist("Manuel", binding.runner1 ,width)
        val runner2 = Cyclist("Carlos", binding.runner2, width)
        val runner3 = Cyclist("Xenxo", binding.runner3, width)
        val job = CoroutineScope(Dispatchers.Default).launch {
            println("En la corrutina <-----------")
            launch {
                runner1.run()
            }
            launch {
                runner2.run()
            }
            launch {
                runner3.run()
            }
        }
        binding.panicButton.setOnClickListener{
            CoroutineScope(Dispatchers.Default).launch {
                job.cancelAndJoin()
            }
        }
    }
}