package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityTwentyFiveBinding

class TwentyFiveActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentyFiveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentyFiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@TwentyFiveActivity, TwentyThreeActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@TwentyFiveActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.pencemaran_air))
                    it.putExtra(SixActivity.EXTRA_DESC, getString(R.string.pencemaran_air_instruksi))
                    it.putExtra(SixActivity.EXTRA_FROM, 25)
                    startActivity(it)
                }
            }
        }
    }
}