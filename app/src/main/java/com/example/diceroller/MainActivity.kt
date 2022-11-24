package com.example.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var imageview: ImageView
    lateinit var rollButton:Button
     var diceNumber=""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageview = findViewById(R.id.imageView)
        rollButton=findViewById(R.id.roll_button)
        rollButton.setOnClickListener{
            rollDice()
            Toast.makeText(this,diceNumber, Toast.LENGTH_SHORT).show()

        }
    }
     fun rollDice() {
        val randomInt=Random.nextInt(6)+1
         diceNumber = if(randomInt==6){
             "You Got Number  $randomInt.\n Congrats You Can Roll Once Again"
         } else
             "You Got Number  $randomInt."
       val drawableResource= when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else ->  R.drawable.dice_6
        }
        imageview.setImageResource(drawableResource)
    }


}