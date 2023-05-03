package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivityTwentyOneBinding

class TwentyOneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentyOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentyOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@TwentyOneActivity, TwentyActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@TwentyOneActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.penebangan_liar))
                    it.putExtra(SixActivity.EXTRA_DESC, getString(R.string.penebangan_liar_instruksi))
                    it.putExtra(SixActivity.EXTRA_FROM, 21)
                    startActivity(it)
                }
            }
        }
    }
}