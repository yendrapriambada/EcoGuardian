package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivitySixteenBinding
import com.fikri.ecoguardian.databinding.ActivityTwoBinding

class SixteenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySixteenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySixteenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@SixteenActivity, FourteenActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@SixteenActivity, SeventeenActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}