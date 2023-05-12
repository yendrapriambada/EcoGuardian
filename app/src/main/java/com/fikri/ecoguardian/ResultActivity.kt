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


        var scoreQuiz = intent.getFloatExtra("hasilScore", 0f).toInt()

        if (scoreQuiz == 99) scoreQuiz = 100

        var persentase = 100
        when (scoreQuiz) {
            in 1..10 -> {
                persentase = 90
            }
            in 11..20 -> {
                persentase = 80
            }
            in 21..40 -> {
                persentase = 80
            }
            in 41..60 -> {
                persentase = 60
            }
            in 61..80 -> {
                persentase = 40
            }
            in 81..100 -> {
                persentase = 20
            }
        }

        val persentaseKerusakan = "$persentase%"

        binding.score.text = scoreQuiz.toString().trim()
        binding.persentase.text = persentaseKerusakan

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