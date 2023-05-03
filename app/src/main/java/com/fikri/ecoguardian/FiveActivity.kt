package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityFiveBinding

class FiveActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@FiveActivity, FourActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@FiveActivity, SixActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}