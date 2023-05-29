package com.fikri.ecoguardian

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityFourBinding

class FourActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // create Shared Preference
        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        // getPref
        val dataPageFour = sharedPref.getString("pageFour", "default").toString()

        if (dataPageFour != "default") {
            binding.edtPageFour.setText(dataPageFour)
        }

        binding.apply {
            btnPrev.setOnClickListener {
                backIntent()
            }

            btnNext.setOnClickListener {
                // savePref
                editor.putString("pageFour", binding.edtPageFour.text.toString().trim())
                editor.apply()

                Intent(this@FourActivity, FiveActivity::class.java).also {
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
        Intent(this@FourActivity, ThreeActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}