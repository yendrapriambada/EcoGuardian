package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityFourteenBinding

class FourteenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourteenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourteenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                backIntent()
            }

            btnNext.setOnClickListener {
                Intent(this@FourteenActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.title_tsunami))
                    it.putExtra(SixActivity.EXTRA_DESC, getString(R.string.title_tsunami_instruksi))
                    it.putExtra(SixActivity.EXTRA_FROM, 14)
                    it.putExtra(SixActivity.EXTRA_VIDEO, R.raw.tsunami)
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
        Intent(this@FourteenActivity, ThirteenActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}