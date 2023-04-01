package ru.mirea.ivashechkinav.intentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var tvIntent: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initTextView()
    }
    private fun initTextView() {
        tvIntent = findViewById(R.id.tvIntentText)
        val extraTimeString = intent.getStringExtra(timeString) ?: "неизвестно"
        tvIntent.text = "КВАДРАТ ЗНАЧЕНИЯ " +
                "МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ ${7*7}, а текущее " +
                "время $extraTimeString»."
    }
    companion object {
        const val timeString = "timeString"
    }
}