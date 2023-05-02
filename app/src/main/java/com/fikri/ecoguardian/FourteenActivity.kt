package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivityFourteenBinding
import com.fikri.ecoguardian.databinding.ActivityTwoBinding

class FourteenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourteenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourteenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@FourteenActivity, ThirteenActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@FourteenActivity, SixteenActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}