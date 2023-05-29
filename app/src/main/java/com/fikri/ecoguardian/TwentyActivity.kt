package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.SixActivity.Companion.EXTRA_FROM
import com.fikri.ecoguardian.databinding.ActivityTwentyBinding

class TwentyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                backIntent()
            }

            btnNext.setOnClickListener {
                Intent(this@TwentyActivity, TemplateStudentResponsesActivity::class.java).also {
                    it.putExtra(EXTRA_FROM, 20)
                    startActivity(it)
                }
                finish()
            }
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backIntent()
            }
        })
    }

    private fun backIntent() {
        Intent(this@TwentyActivity, NineteenActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}