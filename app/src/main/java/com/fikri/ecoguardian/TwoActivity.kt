package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityTwoBinding

class TwoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvKataPengantar.movementMethod = ScrollingMovementMethod()

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@TwoActivity, MainActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@TwoActivity, ThreeActivity::class.java).also {
                    startActivity(it)
                }
            }
        }

    }
}