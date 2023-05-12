package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityGameInstructionsBinding
import com.fikri.ecoguardian.databinding.ActivityTwoBinding

class GameInstructionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameInstructionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameInstructionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@GameInstructionsActivity, ThreeActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@GameInstructionsActivity, GameActivity::class.java).also {
                    startActivity(it)
                }
            }
        }

    }
}