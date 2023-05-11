package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityTwentySevenBinding

class TwentySevenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentySevenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentySevenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@TwentySevenActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.pencemaran_air))
                    it.putExtra(
                        SixActivity.EXTRA_DESC,
                        getString(R.string.pencemaran_air_instruksi)
                    )
                    it.putExtra(SixActivity.EXTRA_FROM, 25)
                    it.putExtra(SixActivity.EXTRA_VIDEO, R.raw.sampah)
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@TwentySevenActivity, TwentyEightActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}