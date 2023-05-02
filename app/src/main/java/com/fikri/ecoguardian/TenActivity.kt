package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivityEightBinding
import com.fikri.ecoguardian.databinding.ActivityTenBinding

class TenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@TenActivity, NineActivity::class.java).also {
                    startActivity(it)
                }
            }

            btnNext.setOnClickListener {
                Intent(this@TenActivity, NineActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}
