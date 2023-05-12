package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val scoreQuiz = intent.getIntExtra("hasilScore", 0)

        binding.score.text = scoreQuiz.toString().trim()

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@ResultActivity, GameInstructionsActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnHome.setOnClickListener {
                Intent(this@ResultActivity, ThreeActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}