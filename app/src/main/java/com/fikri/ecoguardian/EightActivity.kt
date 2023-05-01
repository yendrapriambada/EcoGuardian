package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivityEightBinding
import com.fikri.ecoguardian.databinding.ActivitySixBinding

class EightActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@EightActivity, SixActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@EightActivity, NineActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}