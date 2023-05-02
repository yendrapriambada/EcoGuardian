package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivityNineteenBinding
import com.fikri.ecoguardian.databinding.ActivitySixteenBinding

class NineteenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNineteenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNineteenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@NineteenActivity, SeventeenActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@NineteenActivity, TwentyActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}