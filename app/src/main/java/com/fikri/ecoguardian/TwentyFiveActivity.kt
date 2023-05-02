package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivityTwentyFiveBinding
import com.fikri.ecoguardian.databinding.ActivityTwentyThreeBinding

class TwentyFiveActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentyFiveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentyFiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@TwentyFiveActivity, TwentyThreeActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@TwentyFiveActivity, TwentySevenActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}