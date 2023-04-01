package ru.mirea.ivashechkinav.intentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ru.mirea.ivashechkinav.intentapp.SecondActivity.Companion.timeString
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btnSendIntent)
        button.setOnClickListener { createIntent() }
    }

    private fun getTimeString(): String {
        val dateInMillis = System.currentTimeMillis()
        val format = "yyyy-MM-dd HH:mm:ss"
        val sdf = SimpleDateFormat(format)
        return sdf.format(Date(dateInMillis))
    }

    private fun createIntent() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(timeString, getTimeString())
        startActivity(intent)
    }

}