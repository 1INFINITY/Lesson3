package ru.mirea.ivashechkinav.favoritebook

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.mirea.ivashechkinav.favoritebook.MainActivity.Companion.KEY
import ru.mirea.ivashechkinav.favoritebook.MainActivity.Companion.USER_MESSAGE
import java.security.Key


class ShareActivity : AppCompatActivity() {
    private lateinit var textViewUserBook: TextView
    private lateinit var writeBook: EditText
    private lateinit var buttonSend: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        textViewUserBook = findViewById(R.id.tvFavoriteBook)
        writeBook = findViewById(R.id.etWriteBook)
        buttonSend = findViewById(R.id.btnSend)

        val book = intent.getStringExtra(KEY)
        textViewUserBook.text = "Мой любимая книга: ${book ?: "неизвестна"}"
        buttonSend.setOnClickListener { sendIntentBack() }
    }

    private fun sendIntentBack() {
        val data = Intent()
        data.putExtra(USER_MESSAGE, writeBook.editableText.toString())
        setResult(RESULT_OK, data)
        finish()
    }
}