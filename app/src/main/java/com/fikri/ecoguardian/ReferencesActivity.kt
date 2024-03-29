package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivityReferencesBinding
import com.fikri.ecoguardian.databinding.ActivityTwentyEightBinding

class ReferencesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReferencesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@ReferencesActivity, TwentyEightActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnHome.setOnClickListener {
                Intent(this@ReferencesActivity, ThreeActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}