package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            }

            btnGames.setOnClickListener {
                Intent(this@ThreeActivity, GameInstructionsActivity::class.java).also { startActivity(it) }
            }
        }
    }
}