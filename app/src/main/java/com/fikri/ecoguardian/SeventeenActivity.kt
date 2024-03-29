package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivitySeventeenBinding

class SeventeenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeventeenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeventeenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@SeventeenActivity, SixteenActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@SeventeenActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.tanah_longsor))
                    it.putExtra(SixActivity.EXTRA_DESC, getString(R.string.tanah_longsor_instruksi))
                    it.putExtra(SixActivity.EXTRA_FROM, 17)
                    it.putExtra(SixActivity.EXTRA_VIDEO, R.raw.longsor)
                    startActivity(it)
                }
            }
        }
    }
}