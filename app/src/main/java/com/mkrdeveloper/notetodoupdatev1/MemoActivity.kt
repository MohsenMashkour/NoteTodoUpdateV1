package com.mkrdeveloper.notetodoupdatev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.mkrdeveloper.notetodoupdatev1.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMemo)

        setupActionBarWithNavController(findNavController(R.id.memoFrContainer))
    }

    override fun onSupportNavigateUp(): Boolean {

        val navController = findNavController(R.id.memoFrContainer)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}