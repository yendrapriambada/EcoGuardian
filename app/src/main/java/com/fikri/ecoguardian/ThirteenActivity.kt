package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivityElevenBinding
import com.fikri.ecoguardian.databinding.ActivityThirteenBinding

class ThirteenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirteenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirteenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@ThirteenActivity, ElevenActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@ThirteenActivity, FourteenActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}