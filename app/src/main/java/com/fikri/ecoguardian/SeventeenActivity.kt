package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivitySeventeenBinding
import com.fikri.ecoguardian.databinding.ActivitySixteenBinding

class SeventeenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeventeenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeventeenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@SeventeenActivity, SixteenActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@SeventeenActivity, NineteenActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}