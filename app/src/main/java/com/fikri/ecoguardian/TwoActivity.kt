package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivityMainBinding
import com.fikri.ecoguardian.databinding.ActivityTwoBinding

class TwoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPrev.setOnClickListener {
            Intent(this@TwoActivity, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnNext.setOnClickListener {
            Intent(this@TwoActivity, ThreeActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}