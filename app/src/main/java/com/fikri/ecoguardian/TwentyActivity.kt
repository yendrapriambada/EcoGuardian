package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivitySixteenBinding
import com.fikri.ecoguardian.databinding.ActivityTwentyBinding

class TwentyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@TwentyActivity, NineteenActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@TwentyActivity, TwentyOneActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}