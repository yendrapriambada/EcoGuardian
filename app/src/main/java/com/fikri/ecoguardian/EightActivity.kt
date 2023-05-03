package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityEightBinding

class EightActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@EightActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.gunung_meletus))
                    it.putExtra(
                        SixActivity.EXTRA_DESC,
                        getString(R.string.gunung_meletus_instruksi)
                    )
                    it.putExtra(SixActivity.EXTRA_FROM, 6)
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@EightActivity, NineActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}