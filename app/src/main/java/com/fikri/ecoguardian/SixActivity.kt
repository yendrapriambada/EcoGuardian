package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivitySixBinding

class SixActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySixBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySixBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                backIntent()
            }

            btnNext.setOnClickListener {
                Intent(this@SixActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(EXTRA_TITLE, getString(R.string.gunung_meletus))
                    it.putExtra(EXTRA_DESC, getString(R.string.gunung_meletus_instruksi))
                    it.putExtra(EXTRA_FROM, 6)
                    it.putExtra(EXTRA_VIDEO, R.raw.gunung)
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
        Intent(this@SixActivity, FiveActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_FROM = "extra_from"
        const val EXTRA_VIDEO = "extra_video"
        const val EXTRA_TEXT = "extra_text"
    }
}