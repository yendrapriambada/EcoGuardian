package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivitySixteenBinding

class SixteenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySixteenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySixteenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupMusic()

        binding.apply {
            btnPrev.setOnClickListener {
                backIntent()
            }

            btnNext.setOnClickListener {
                Intent(this@SixteenActivity, SeventeenActivity::class.java).also {
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
        Intent(this@SixteenActivity, TemplateVideoMateriActivity::class.java).also {
            it.putExtra(SixActivity.EXTRA_TITLE, getString(R.string.title_tsunami))
            it.putExtra(SixActivity.EXTRA_DESC, getString(R.string.title_tsunami_instruksi))
            it.putExtra(SixActivity.EXTRA_FROM, 14)
            it.putExtra(SixActivity.EXTRA_VIDEO, R.raw.tsunami)
            startActivity(it)
        }
        finish()
    }

    private fun setupMusic() {
        val action = "PLAY"
        val myService = Intent(this@SixteenActivity, MusicService::class.java)
        myService.action = action
        startService(myService)
    }
}