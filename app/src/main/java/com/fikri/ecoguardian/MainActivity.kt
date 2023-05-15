package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isMusicPlay: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupMusic()

        binding.btnNext.setOnClickListener {
            Intent(this@MainActivity, TwoActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun setupMusic(){
        val action = "PLAY"
        val myService = Intent(this@MainActivity, MusicService::class.java)
        myService.action = action
        startService(myService)

        if(isMusicPlay) {
            showPlayButton(true)
        } else {
            showPlayButton(false)
        }

        binding.apply {
            btnPlay.setOnClickListener {
                val action = "STOP"
                val myService = Intent(this@MainActivity, MusicService::class.java)
                myService.action = action
                startService(myService)

                showPlayButton(false)
                isMusicPlay = false
            }

            btnMute.setOnClickListener {
                val action = "PLAY"
                val myService = Intent(this@MainActivity, MusicService::class.java)
                myService.action = action
                startService(myService)

                showPlayButton(true)
                isMusicPlay = true
            }
        }
    }
    private fun showPlayButton(playing: Boolean){
        if(playing) {
            binding.apply {
                btnMute.visibility = View.GONE
                btnPlay.visibility = View.VISIBLE
            }
        } else {
            binding.apply {
                btnMute.visibility = View.VISIBLE
                btnPlay.visibility = View.GONE
            }
        }
    }
    override fun onResume() {
        super.onResume()
        if(isMusicPlay){
            showPlayButton(true)
        } else {
            showPlayButton(false)
        }
    }
}