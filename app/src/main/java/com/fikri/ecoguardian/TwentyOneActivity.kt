package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityTwentyOneBinding

class TwentyOneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentyOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentyOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                backIntent()
            }

            btnNext.setOnClickListener {
                Intent(this@TwentyOneActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.penebangan_liar))
                    it.putExtra(
                        SixActivity.EXTRA_DESC,
                        getString(R.string.penebangan_liar_instruksi)
                    )
                    it.putExtra(SixActivity.EXTRA_FROM, 21)
                    it.putExtra(SixActivity.EXTRA_VIDEO, R.raw.tidak_ada_hutan)
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
        Intent(this@TwentyOneActivity, TemplateStudentResponsesActivity::class.java).also {
            it.putExtra(SixActivity.EXTRA_FROM, 20)
            startActivity(it)
        }
        finish()
    }
}