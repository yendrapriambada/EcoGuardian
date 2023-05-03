package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivityFourteenBinding
import com.fikri.ecoguardian.databinding.ActivityTwoBinding

class FourteenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourteenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourteenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@FourteenActivity, ThirteenActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@FourteenActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.title_tsunami))
                    it.putExtra(SixActivity.EXTRA_DESC, getString(R.string.title_tsunami_instruksi))
                    it.putExtra(SixActivity.EXTRA_FROM, 14)
                    startActivity(it)
                }
            }
        }
    }
}