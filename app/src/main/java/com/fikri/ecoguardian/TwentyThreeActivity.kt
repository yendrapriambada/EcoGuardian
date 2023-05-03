package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.fikri.ecoguardian.databinding.ActivityTwentyThreeBinding
import com.fikri.ecoguardian.databinding.ActivityTwoBinding

class TwentyThreeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentyThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentyThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@TwentyThreeActivity, TwentyOneActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@TwentyThreeActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.pencemaran_udara))
                    it.putExtra(SixActivity.EXTRA_DESC, getString(R.string.pencemaran_udara_instruksi))
                    it.putExtra(SixActivity.EXTRA_FROM, 23)
                    startActivity(it)
                }
            }
        }
    }
}