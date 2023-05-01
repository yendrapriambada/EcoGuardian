package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivityFourBinding
import com.fikri.ecoguardian.databinding.ActivitySixBinding

class SixActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySixBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySixBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@SixActivity, FiveActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@SixActivity, EightActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}