package com.fikri.ecoguardian

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.SixActivity.Companion.EXTRA_DESC
import com.fikri.ecoguardian.SixActivity.Companion.EXTRA_FROM
import com.fikri.ecoguardian.SixActivity.Companion.EXTRA_TITLE
import com.fikri.ecoguardian.SixActivity.Companion.EXTRA_VIDEO
import com.fikri.ecoguardian.databinding.ActivityTemplateVideoMateriBinding

class TemplateVideoMateriActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTemplateVideoMateriBinding
    private lateinit var intentPrev: Intent
    private lateinit var intentNext: Intent
    private lateinit var atribut: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemplateVideoMateriBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupMusic()

        // create Shared Preference
        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        // video
        val mediaController = MediaController(this)
        mediaController.setAnchorView(binding.videoView)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val desc = intent.getStringExtra(EXTRA_DESC)
        val video = intent.getIntExtra(EXTRA_VIDEO, 0)
        val offlineVideo = Uri.parse("android.resource://$packageName/${video}")

        binding.apply {
            tvTitle.text = title
            tvDesc.text = desc

            // video
            videoView.setMediaController(mediaController)
            videoView.setVideoURI(offlineVideo)
            videoView.requestFocus()
            videoView.start()
        }


        when (intent.getIntExtra(EXTRA_FROM, 0)) {
            6 -> {
                val dataPageSeven = sharedPref.getString("pageSeven", "default").toString()
                if (dataPageSeven != "default") binding.editText.setText(dataPageSeven)

                atribut = "pageSeven"
                intentPrev =
                    Intent(this@TemplateVideoMateriActivity, SixActivity::class.java)
                intentNext =
                    Intent(this@TemplateVideoMateriActivity, EightActivity::class.java)
            }
            11 -> {
                val dataPageTwelve = sharedPref.getString("pageTwelve", "default").toString()
                if (dataPageTwelve != "default") binding.editText.setText(dataPageTwelve)

                atribut = "pageTwelve"
                intentPrev =
                    Intent(this@TemplateVideoMateriActivity, ElevenActivity::class.java)
                intentNext =
                    Intent(this@TemplateVideoMateriActivity, ThirteenActivity::class.java)

            }
            14 -> {
                val dataPageFiveteen = sharedPref.getString("pageFiveTeen", "default").toString()
                if (dataPageFiveteen != "default") binding.editText.setText(dataPageFiveteen)

                atribut = "pageFiveTeen"
                intentPrev =
                    Intent(this@TemplateVideoMateriActivity, FourteenActivity::class.java)
                intentNext =
                    Intent(this@TemplateVideoMateriActivity, SixteenActivity::class.java)
            }
            17 -> {
                val dataPageEightTeen = sharedPref.getString("pageEightTeen", "default").toString()
                if (dataPageEightTeen != "default") binding.editText.setText(dataPageEightTeen)

                atribut = "pageEightTeen"
                intentPrev =
                    Intent(this@TemplateVideoMateriActivity, SeventeenActivity::class.java)
                intentNext =
                    Intent(this@TemplateVideoMateriActivity, NineteenActivity::class.java)
            }
            21 -> {
                val dataPageTwentyTwo = sharedPref.getString("pageTwentyTwo", "default").toString()
                if (dataPageTwentyTwo != "default") binding.editText.setText(dataPageTwentyTwo)

                atribut = "pageTwentyTwo"
                intentPrev =
                    Intent(this@TemplateVideoMateriActivity, TwentyOneActivity::class.java)
                intentNext =
                    Intent(this@TemplateVideoMateriActivity, TwentyThreeActivity::class.java)
            }
            23 -> {
                val dataPageTwentyFour =
                    sharedPref.getString("pageTwentyFour", "default").toString()
                if (dataPageTwentyFour != "default") binding.editText.setText(dataPageTwentyFour)

                atribut = "pageTwentyFour"
                intentPrev =
                    Intent(this@TemplateVideoMateriActivity, TwentyThreeActivity::class.java)
                intentNext =
                    Intent(this@TemplateVideoMateriActivity, TwentyFiveActivity::class.java)
            }
            25 -> {
                val dataPageTwentySix = sharedPref.getString("pageTwentySix", "default").toString()
                if (dataPageTwentySix != "default") binding.editText.setText(dataPageTwentySix)

                atribut = "pageTwentySix"
                intentPrev =
                    Intent(this@TemplateVideoMateriActivity, TwentyFiveActivity::class.java)
                intentNext =
                    Intent(this@TemplateVideoMateriActivity, TwentySevenActivity::class.java)
            }
        }

        binding.apply {
            btnPrev.setOnClickListener {
                backIntent()
            }

            btnNext.setOnClickListener {
                // savePref
                editor.putString(atribut, binding.editText.text.toString().trim())
                editor.apply()

                startActivity(intentNext)
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
        startActivity(intentPrev)
        finish()
    }

    private fun setupMusic() {
        val action = "STOP"
        val myService = Intent(this@TemplateVideoMateriActivity, MusicService::class.java)
        myService.action = action
        startService(myService)
    }
}
