package com.example.cyclistapp.model

import android.widget.ImageView
import kotlinx.coroutines.delay
import kotlin.properties.Delegates
import kotlin.random.Random

class Cyclist(val name: String, val image: ImageView, val meta: Float, var currentPosition: Float = image.x) {
    suspend fun run(){
        while (currentPosition < meta ) {
            println("En el run <--------------")
            delay((0..10000).random().toLong())
            currentPosition += 5
            image.x = currentPosition
            println("$name esta en $currentPosition <-------------")
        }
    }
}