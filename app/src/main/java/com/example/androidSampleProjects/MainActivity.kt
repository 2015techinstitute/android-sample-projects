package com.example.androidSampleProjects

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidSampleProjects.databinding.ActivityMainBinding
import com.example2.mvc.ui.MVCActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPassiveMVC.setOnClickListener { startActivity(Intent(this, MVCActivity::class.java)) }
        binding.btnActiveMVC.setOnClickListener { startActivity(Intent(this, MVCActivity::class.java)) }
        binding.btnMVP.setOnClickListener { startActivity(Intent(this, MVCActivity::class.java)) }
    }
}