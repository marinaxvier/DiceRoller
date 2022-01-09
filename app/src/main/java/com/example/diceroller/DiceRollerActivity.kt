package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*

class DiceRollerActivity : AppCompatActivity() {

    private lateinit var diceImage: ImageView
    private lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)

        initViews()

        setListeners()

    }

    private fun setListeners() {
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun initViews() {
        rollButton = findViewById(R.id.roll_button)
        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        val randomInt = getDiceValue()

        val drawableResource = getDiceImage(randomInt)

        setDiceImage(drawableResource)

    }

    private fun getDiceValue(): Int {
        val randomInt = Random().nextInt(6) + 1
        return randomInt
    }

    private fun setDiceImage(drawableResource: Int) {
        diceImage.setImageResource(drawableResource)
    }

    private fun getDiceImage(randomInt: Int): Int {
        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}