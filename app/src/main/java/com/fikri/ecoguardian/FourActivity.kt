package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityFourBinding

class FourActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@FourActivity, ThreeActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@FourActivity, FiveActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}