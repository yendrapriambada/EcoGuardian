package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.databinding.ActivityTwentyEightBinding
import com.fikri.ecoguardian.databinding.ActivityTwentySevenBinding

class TwentyEightActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwentyEightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwentyEightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnPrev.setOnClickListener {
                Intent(this@TwentyEightActivity, TwentySevenActivity::class.java).also {
                    startActivity(it)
                }
            }

//            btnNext.setOnClickListener {
//                Intent(this@TwentyEightActivity, TwentyEightActivity::class.java).also {
//                    startActivity(it)
//                }
//            }
        }
    }
}