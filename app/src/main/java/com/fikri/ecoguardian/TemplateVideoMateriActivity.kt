package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.SixActivity.Companion.EXTRA_DESC
import com.fikri.ecoguardian.SixActivity.Companion.EXTRA_FROM
import com.fikri.ecoguardian.SixActivity.Companion.EXTRA_TITLE
import com.fikri.ecoguardian.databinding.ActivityTemplateVideoMateriBinding

class TemplateVideoMateriActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTemplateVideoMateriBinding
    private lateinit var intentPrev: Intent
    private lateinit var intentNext: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemplateVideoMateriBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val desc = intent.getStringExtra(EXTRA_DESC)

        binding.apply {
            tvTitle.text = title
            tvDesc.text = desc
        }

        when (intent.getIntExtra(EXTRA_FROM, 0)) {
            6 -> {
                intentPrev =
                    Intent(this@TemplateVideoMateriActivity, SixActivity::class.java)
                intentNext =
                    Intent(this@TemplateVideoMateriActivity, EightActivity::class.java)
            }
            11 -> {
                intentPrev =
                    Intent(this@TemplateVideoMateriActivity, ElevenActivity::class.java)
                intentNext =
                    Intent(this@TemplateVideoMateriActivity, ThirteenActivity::class.java)
            }
            14 -> {
                intentPrev =
                    Intent(this@TemplateVideoMateriActivity, FourteenActivity::class.java)
                intentNext =
                    Intent(this@TemplateVideoMateriActivity, SixteenActivity::class.java)
            }
            17 -> {
                intentPrev =
                    Intent(this@TemplateVideoMateriActivity, SeventeenActivity::class.java)
                intentNext =
                    Intent(this@TemplateVideoMateriActivity, NineteenActivity::class.java)
            }
            21 -> {
                intentPrev =
                    Intent(this@TemplateVideoMateriActivity, TwentyOneActivity::class.java)
                intentNext =
                    Intent(this@TemplateVideoMateriActivity, TwentyThreeActivity::class.java)
            }
            23 -> {
                intentPrev =
                    Intent(this@TemplateVideoMateriActivity, TwentyThreeActivity::class.java)
                intentNext =
                    Intent(this@TemplateVideoMateriActivity, TwentyFiveActivity::class.java)
            }
            25 -> {
                intentPrev =
                    Intent(this@TemplateVideoMateriActivity, TwentyFiveActivity::class.java)
                intentNext =
                    Intent(this@TemplateVideoMateriActivity, TwentySevenActivity::class.java)
            }
        }

        binding.apply {
            btnPrev.setOnClickListener {
                startActivity(intentPrev)
            }

            btnNext.setOnClickListener {
                startActivity(intentNext)
            }
        }
    }
}
