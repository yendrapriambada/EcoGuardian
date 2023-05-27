package com.fikri.ecoguardian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fikri.ecoguardian.SixActivity.Companion.EXTRA_FROM
import com.fikri.ecoguardian.databinding.ActivityTemplateStudentResponsesBinding

class TemplateStudentResponsesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTemplateStudentResponsesBinding
    private lateinit var intentPrev: Intent
    private lateinit var intentNext: Intent
    private lateinit var atribut: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemplateStudentResponsesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // create Shared Preference
        val sharedPref = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        when (intent.getIntExtra(EXTRA_FROM, 0)) {
            20 -> {
                val dataPageTwentyOne = sharedPref.getString("pageTwentyOne", "default").toString()
                if (dataPageTwentyOne != "default") binding.editText.setText(dataPageTwentyOne)

                binding.npcTitle.setImageResource(R.drawable.asset_21)

                atribut = "pageTwentyOne"
                intentPrev = Intent(this@TemplateStudentResponsesActivity, TwentyActivity::class.java)
                intentNext = Intent(this@TemplateStudentResponsesActivity, TwentyOneActivity::class.java)
            }
            27 -> {
                val dataPageTwentyEight = sharedPref.getString("pageTwentyEight", "default").toString()
                if (dataPageTwentyEight != "default") binding.editText.setText(dataPageTwentyEight)

                binding.npcTitle.setImageResource(R.drawable.asset_28)

                atribut = "pageTwentyEight"
                intentPrev = Intent(this@TemplateStudentResponsesActivity, TwentySevenActivity::class.java)
                intentNext = Intent(this@TemplateStudentResponsesActivity, TwentyEightActivity::class.java)
            }
        }

        binding.apply {
            btnPrev.setOnClickListener {
                startActivity(intentPrev)
            }

            btnNext.setOnClickListener {
                startActivity(intentNext)

                // savePref
                editor.putString(atribut, binding.editText.text.toString().trim())
                editor.apply()
            }
        }

    }
}