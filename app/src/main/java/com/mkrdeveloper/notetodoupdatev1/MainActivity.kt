package com.mkrdeveloper.notetodoupdatev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mkrdeveloper.notetodoupdatev1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            cardViewMemo.setOnClickListener {
                val intent = Intent(this@MainActivity, MemoActivity::class.java)
                startActivity(intent)
            }
            cardViewTodo.setOnClickListener {
                val intent = Intent(this@MainActivity, TodoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}