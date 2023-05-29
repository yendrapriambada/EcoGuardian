package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityThreeBinding

class ThreeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnStudy.setOnClickListener {
                Intent(this@ThreeActivity, FourActivity::class.java).also { startActivity(it) }
                finish()
            }

            btnGames.setOnClickListener {
                Intent(this@ThreeActivity, Game2Activity::class.java).also { startActivity(it) }
                finish()
            }
            btnPrev.setOnClickListener {
                backIntent()
            }
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backIntent()
            }
        })
    }

    private fun backIntent() {
        Intent(this@ThreeActivity, TwoActivity::class.java).also { startActivity(it) }
        finish()
    }
}