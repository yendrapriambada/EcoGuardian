package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityTwentySevenBinding

class TwentySevenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentySevenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentySevenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupMusic()

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@TwentySevenActivity, TemplateVideoMateriActivity::class.java).also {
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

            btnNext.setOnClickListener {
                Intent(this@TwentySevenActivity, TemplateStudentResponsesActivity::class.java).also {
                    it.putExtra(SixActivity.EXTRA_TEXT, getString(R.string.tanggapan_siswa_bencana_akibat_manusia))
                    it.putExtra(SixActivity.EXTRA_FROM, 27)
                    startActivity(it)
                }
            }
        }
    }

    private fun setupMusic(){
        val action = "PLAY"
        val myService = Intent(this@TwentySevenActivity, MusicService::class.java)
        myService.action = action
        startService(myService)
    }
}