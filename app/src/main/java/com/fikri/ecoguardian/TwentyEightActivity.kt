package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityTwentyEightBinding

class TwentyEightActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentyEightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentyEightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@TwentyEightActivity, TemplateStudentResponsesActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TEXT, getString(R.string.tanggapan_siswa_bencana_akibat_manusia))
                    it.putExtra(SixActivity.EXTRA_FROM, 27)
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@TwentyEightActivity, ReferencesActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}