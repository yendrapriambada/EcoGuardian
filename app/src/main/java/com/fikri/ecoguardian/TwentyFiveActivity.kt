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

        setupMusic()

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@TwentyFiveActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.pencemaran_udara))
                    it.putExtra(
                        SixActivity.EXTRA_DESC,
                        getString(R.string.pencemaran_udara_instruksi)
                    )
                    it.putExtra(SixActivity.EXTRA_FROM, 23)
                    it.putExtra(SixActivity.EXTRA_VIDEO, R.raw.polusi_udara)
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@TwentyFiveActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.pencemaran_air))
                    it.putExtra(
                        SixActivity.EXTRA_DESC,
                        getString(R.string.pencemaran_air_instruksi)
                    )
                    it.putExtra(SixActivity.EXTRA_FROM, 25)
                    it.putExtra(SixActivity.EXTRA_VIDEO, R.raw.sampah)
                    startActivity(it)
                }
            }
        }
    }

    private fun setupMusic(){
        val action = "PLAY"
        val myService = Intent(this@TwentyFiveActivity, MusicService::class.java)
        myService.action = action
        startService(myService)
    }
}