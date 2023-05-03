package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityElevenBinding

class ElevenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityElevenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityElevenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@ElevenActivity, TenActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@ElevenActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.gempa_bumi))
                    it.putExtra(SixActivity.EXTRA_DESC, getString(R.string.gempa_bumi_instruksi))
                    it.putExtra(SixActivity.EXTRA_FROM, 11)
                    startActivity(it)
                }
            }
        }
    }
}