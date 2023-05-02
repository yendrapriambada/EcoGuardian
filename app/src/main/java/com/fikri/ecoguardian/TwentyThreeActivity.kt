package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivityTwentyThreeBinding
import com.fikri.ecoguardian.databinding.ActivityTwoBinding

class TwentyThreeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentyThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentyThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@TwentyThreeActivity, TwentyOneActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@TwentyThreeActivity, TwentyFiveActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}