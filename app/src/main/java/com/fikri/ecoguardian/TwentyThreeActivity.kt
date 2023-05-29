package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityTwentyThreeBinding

class TwentyThreeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentyThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentyThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupMusic()

        binding.apply {
            btnPrev.setOnClickListener {
                backIntent()
            }

            btnNext.setOnClickListener {
                Intent(this@TwentyThreeActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.pencemaran_udara))
                    it.putExtra(
                        SixActivity.EXTRA_DESC,
                        getString(R.string.pencemaran_udara_instruksi)
                    )
                    it.putExtra(SixActivity.EXTRA_FROM, 23)
                    it.putExtra(SixActivity.EXTRA_VIDEO, R.raw.polusi_udara)
                    startActivity(it)
                }
                finish()
            }
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backIntent()
            }
        })
    }

    private fun backIntent() {
        Intent(this@TwentyThreeActivity, TemplateVideoMateriActivity::class.java).also {
            it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.penebangan_liar))
            it.putExtra(
                SixActivity.EXTRA_DESC,
                getString(R.string.penebangan_liar_instruksi)
            )
            it.putExtra(SixActivity.EXTRA_FROM, 21)
            it.putExtra(SixActivity.EXTRA_VIDEO, R.raw.tidak_ada_hutan)
            startActivity(it)
        }
        finish()
    }

    private fun setupMusic() {
        val action = "PLAY"
        val myService = Intent(this@TwentyThreeActivity, MusicService::class.java)
        myService.action = action
        startService(myService)
    }
}