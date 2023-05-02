package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivityTwentySevenBinding
import com.fikri.ecoguardian.databinding.ActivityTwentyThreeBinding

class TwentySevenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentySevenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentySevenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@TwentySevenActivity, TwentyFiveActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@TwentySevenActivity, TwentyEightActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}