package ru.mirea.ivashechkinav.sharer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var button2: Button
    private val launcher = initLauncher()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.btnSendIntent)
        button.setOnClickListener { sendIntent() }
        button2 = findViewById(R.id.btnSendIntent2)
        button2.setOnClickListener { sendIntentForResult() }
    }

    private fun initLauncher(): ActivityResultLauncher<Intent> {
        val callback = ActivityResultCallback<ActivityResult>() { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intentData = result.data;
                Log.d(MainActivity::class.simpleName, "Data:" + intentData?.dataString);
            }
        }
        return registerForActivityResult<Intent, ActivityResult>(
            ActivityResultContracts.StartActivityForResult(),
            callback
        )
    }

    private fun sendIntentForResult() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "*/*"
        launcher.launch(intent)
    }

    private fun sendIntent() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "*/*"
        intent.putExtra(Intent.EXTRA_TEXT, "Mirea")
        startActivity(Intent.createChooser(intent, "Выбор за вами!"))
    }
}