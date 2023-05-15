package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityNineteenBinding


class NineteenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNineteenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNineteenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupMusic()

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@NineteenActivity, TemplateVideoMateriActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.tanah_longsor))
                    it.putExtra(SixActivity.EXTRA_DESC, getString(R.string.tanah_longsor_instruksi))
                    it.putExtra(SixActivity.EXTRA_FROM, 17)
                    it.putExtra(SixActivity.EXTRA_VIDEO, R.raw.longsor)
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@NineteenActivity, TwentyActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
    private fun setupMusic(){
        val action = "PLAY"
        val myService = Intent(this@NineteenActivity, MusicService::class.java)
        myService.action = action
        startService(myService)
    }
}