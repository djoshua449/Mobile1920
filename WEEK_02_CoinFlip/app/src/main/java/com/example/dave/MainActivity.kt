package com.example.dave
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.ButtonBarLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var flipCoin: ImageView
    lateinit var flipButton: Button
    lateinit var reflipbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        flipCoin=findViewById(R.id.coins) as ImageView
        flipButton=findViewById(R.id.button1) as Button
        reflipbutton=findViewById(R.id.buttonreflip) as Button

        flipButton.setOnClickListener{
            flipCoin()
        }
    }

    private fun flipCoin() {
        val randomInt= Random().nextInt(2)+1
        if (randomInt==1) {
            flipCoin.setImageResource(R.drawable.tailcoin)
            Toast.makeText(this, "TAIL!", Toast.LENGTH_SHORT).show()
        }
        else {
            flipCoin.setImageResource(R.drawable.headcoin)
            Toast.makeText(this, "HEAD!", Toast.LENGTH_SHORT).show()
        }
        val rotateCoin = RotateAnimation(300f, 360f,
            RotateAnimation.RELATIVE_TO_SELF, 5f, RotateAnimation.RELATIVE_TO_SELF, 1f)
        rotateCoin.setDuration(1750)
        flipCoin.startAnimation(rotateCoin)
        supportParentActivityIntent
        System.exit(0)


    }
}