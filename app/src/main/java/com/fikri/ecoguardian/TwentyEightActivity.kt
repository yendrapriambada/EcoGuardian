package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityTwentyEightBinding

class TwentyEightActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentyEightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentyEightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@TwentyEightActivity, TwentySevenActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnHome.setOnClickListener {
                Intent(this@TwentyEightActivity, ThreeActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}