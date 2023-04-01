package ru.mirea.ivashechkinav.favoritebook

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    companion object {
        val KEY = "book_name"
        val USER_MESSAGE = "MESSAGE"
    }
    private lateinit var textViewUserBook: TextView
    private lateinit var btnOpen: Button

    private val activityResultLauncher: ActivityResultLauncher<Intent> = initLauncher()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOpen = findViewById(R.id.btnOpenNewActivity)
        btnOpen.setOnClickListener(this::getInfoAboutBook)

        initTextViewUserBook(null)
    }
    private fun initTextViewUserBook(book: String?) {
        textViewUserBook = findViewById(R.id.tvFavoriteBook)
        book?.let{
            textViewUserBook.text = "Название Вашей любимой книги: $it"
            return
        }
        textViewUserBook.text = "Тут появится название вашей любимой книги!"
    }
    private fun initLauncher(): ActivityResultLauncher<Intent> {
        val callback = ActivityResultCallback<ActivityResult>() { result ->
            if (result.resultCode === RESULT_OK) {
                val data = result.data
                val userBook = data?.getStringExtra(USER_MESSAGE)
                initTextViewUserBook(userBook)
            }
        }
        return registerForActivityResult<Intent, ActivityResult>(
            ActivityResultContracts.StartActivityForResult(),
            callback
        )
    }
    fun getInfoAboutBook(view: View?) {
        val intent = Intent(this, ShareActivity::class.java)
        intent.putExtra(KEY, "Анабасис")
        activityResultLauncher!!.launch(intent)
    }
}