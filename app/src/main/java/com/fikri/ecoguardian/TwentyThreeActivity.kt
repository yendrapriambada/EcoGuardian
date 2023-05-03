package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityTwentyThreeBinding

class TwentyThreeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentyThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentyThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@TwentyThreeActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.penebangan_liar))
                    it.putExtra(
                        SixActivity.EXTRA_DESC,
                        getString(R.string.penebangan_liar_instruksi)
                    )
                    it.putExtra(SixActivity.EXTRA_FROM, 21)
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@TwentyThreeActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.pencemaran_udara))
                    it.putExtra(
                        SixActivity.EXTRA_DESC,
                        getString(R.string.pencemaran_udara_instruksi)
                    )
                    it.putExtra(SixActivity.EXTRA_FROM, 23)
                    startActivity(it)
                }
            }
        }
    }
}