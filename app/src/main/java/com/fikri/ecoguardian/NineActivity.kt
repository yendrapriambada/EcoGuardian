package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivityEightBinding
import com.fikri.ecoguardian.databinding.ActivityNineBinding

class NineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@NineActivity, EightActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@NineActivity, TenActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}