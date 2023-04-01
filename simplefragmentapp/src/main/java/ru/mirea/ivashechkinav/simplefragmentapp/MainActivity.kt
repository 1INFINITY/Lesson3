package ru.mirea.ivashechkinav.simplefragmentapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {
    private lateinit var fragment1: Fragment
    private lateinit var fragment2: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment1 = FirstFragment()
        fragment2 = SecondFragment()

        findViewById<Button>(R.id.btnFirstFragment)?.setOnClickListener(this::onClick)
        findViewById<Button>(R.id.btnSecondFragment)?.setOnClickListener(this::onClick)
    }
    fun onClick(view: View) {
        when (view.id) {
            R.id.btnFirstFragment -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment1).commit()
            R.id.btnSecondFragment -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment2).commit()
            else -> {}
        }
    }
}