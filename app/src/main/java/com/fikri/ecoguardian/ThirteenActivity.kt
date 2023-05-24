package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityThirteenBinding

class ThirteenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirteenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirteenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupMusic()

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@ThirteenActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.gempa_bumi))
                    it.putExtra(SixActivity.EXTRA_DESC, getString(R.string.gempa_bumi_instruksi))
                    it.putExtra(SixActivity.EXTRA_FROM, 11)
                    it.putExtra(SixActivity.EXTRA_VIDEO, R.raw.gempa)
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@ThirteenActivity, FourteenActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
    private fun setupMusic(){
        val action = "PLAY"
        val myService = Intent(this@ThirteenActivity, MusicService::class.java)
        myService.action = action
        startService(myService)
    }
}