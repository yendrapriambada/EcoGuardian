package com.fikri.ecoguardian

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityGameBinding
import java.util.*


class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private var soal: ArrayList<String> = ArrayList()
    private var soalEssay: ArrayList<String> = ArrayList()
    private var opsi1: ArrayList<String> = ArrayList()
    private var opsi2: ArrayList<String> = ArrayList()
    private var opsi3: ArrayList<String> = ArrayList()
    private var opsi4: ArrayList<String> = ArrayList()
    private var jawaban: ArrayList<String> = ArrayList()
    private var jawabanEssay: ArrayList<String> = ArrayList()
    private var jawabanUser: ArrayList<String> = ArrayList()
    private var jawabanUserEssay: ArrayList<String> = ArrayList()
    private var score = 0
    private var indexSoal = 0
    private var progressDialog: ProgressDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val soalArray = resources.getStringArray(R.array.questions)
        val soalEssayArray = resources.getStringArray(R.array.soal_essay)
        val optionsAArray = resources.getStringArray(R.array.optionsA)
        val optionsBArray = resources.getStringArray(R.array.optionsB)
        val optionsCArray = resources.getStringArray(R.array.optionsC)
        val optionsDArray = resources.getStringArray(R.array.optionsD)
        val jawabanArray = resources.getStringArray(R.array.jawaban)
        val jawabanArrayEssay = resources.getStringArray(R.array.jawaban_essay)
        soal = ArrayList<String>(soalArray.toList())
        soalEssay = ArrayList<String>(soalEssayArray.toList())
        opsi1 = ArrayList<String>(optionsAArray.toList())
        opsi2 = ArrayList<String>(optionsBArray.toList())
        opsi3 = ArrayList<String>(optionsCArray.toList())
        opsi4 = ArrayList<String>(optionsDArray.toList())
        jawaban = ArrayList<String>(jawabanArray.toList())
        jawabanEssay = ArrayList<String>(jawabanArrayEssay.toList())

        showDataLayout()

        binding.apply {
            btnOpsiA.setOnClickListener {
                jawabanUser.add("a")
                quizAlgorithm()
            }
            btnOpsiB.setOnClickListener {
                jawabanUser.add("b")
                quizAlgorithm()
            }
            btnOpsiC.setOnClickListener {
                jawabanUser.add("c")
                quizAlgorithm()
            }
            btnOpsiD.setOnClickListener {
                jawabanUser.add("d")
                quizAlgorithm()
            }
            btnSubmit.setOnClickListener {
                val editTextUser = edtJawaban.text.toString().lowercase().trim()
                jawabanUserEssay.add(editTextUser)
                essayAlgorithm()
            }
        }
    }

    private fun essayAlgorithm() {
        hideDataLayoutEssay()
        showLoading()

        Log.e("index", indexSoal.toString())
        Log.e("jawabanUserEssay", jawabanUserEssay[indexSoal])
        Log.e("jawabanEssay", jawabanEssay[indexSoal])

        // check jawaban
        if (jawabanUserEssay[indexSoal] == jawabanEssay[indexSoal].lowercase(Locale.getDefault())) {
            score += 100

            binding.apply {
                when (indexSoal) {
                    0 -> {
                        mangrove16.visibility = View.VISIBLE
                        mangrove17.visibility = View.VISIBLE
                    }
                    1 -> {
                        mangrove18.visibility = View.VISIBLE
                        mangrove19.visibility = View.VISIBLE
                    }
                    2 -> {
                        mangrove20.visibility = View.VISIBLE
                        mangrove21.visibility = View.VISIBLE
                    }
                }
            }
            Toast.makeText(
                applicationContext,
                "Selamat! Anda berhasil menanam 2 Pohon Mangrove.",
                Toast.LENGTH_LONG
            ).show()
        }

        indexSoal++

        if (indexSoal >= soalEssay.size) {
            val totalSoal = soal.size + soalEssay.size
            score /= totalSoal
            val intent = Intent(this@GameActivity, ResultActivity::class.java)
            intent.putExtra("hasilScore", score)
            startActivity(intent)
            finish()
            hideLoading()
        } else {
            showDataLayoutEssay()
            hideLoading()
        }
    }

    private fun quizAlgorithm() {
        hideDataLayout()
        showLoading()

        Log.e("index", indexSoal.toString())
        Log.e("jawabanUser", jawabanUser[indexSoal])
        Log.e("jawaban", jawaban[indexSoal])

        // check jawaban
        if (jawabanUser[indexSoal] == jawaban[indexSoal].lowercase(Locale.getDefault())) {
            score += 100

            binding.apply {
                when (indexSoal) {
                    0 -> mangrove1.visibility = View.VISIBLE
                    1 -> mangrove2.visibility = View.VISIBLE
                    2 -> mangrove3.visibility = View.VISIBLE
                    3 -> mangrove4.visibility = View.VISIBLE
                    4 -> mangrove5.visibility = View.VISIBLE
                    5 -> mangrove6.visibility = View.VISIBLE
                    6 -> mangrove7.visibility = View.VISIBLE
                    7 -> mangrove8.visibility = View.VISIBLE
                    8 -> mangrove9.visibility = View.VISIBLE
                    9 -> mangrove10.visibility = View.VISIBLE
                    10 -> mangrove11.visibility = View.VISIBLE
                    11 -> mangrove12.visibility = View.VISIBLE
                    12 -> mangrove13.visibility = View.VISIBLE
                    13 -> mangrove14.visibility = View.VISIBLE
                    14 -> mangrove15.visibility = View.VISIBLE
                    15 -> mangrove16.visibility = View.VISIBLE
                    16 -> mangrove17.visibility = View.VISIBLE
                    17 -> mangrove18.visibility = View.VISIBLE
                    18 -> mangrove19.visibility = View.VISIBLE
                    19 -> mangrove20.visibility = View.VISIBLE
                    20 -> mangrove21.visibility = View.VISIBLE
                }
            }
            Toast.makeText(
                applicationContext,
                "Selamat! Anda berhasil menanam 1 Pohon Mangrove.",
                Toast.LENGTH_LONG
            ).show()
        }

        indexSoal++

        if (indexSoal >= soal.size) {
            indexSoal = 0   // counting mulai dari awal untuk soal essay
            showDataLayoutEssay()
            hideLoading()
        } else {
            showDataLayout()
            hideLoading()
        }
    }

    private fun showDataLayoutEssay() {
        binding.apply {
            soalPertanyaan.text = soalEssay[indexSoal]
            val soalPertanyaan =
                ObjectAnimator.ofFloat(binding.soalPertanyaan, View.ALPHA, 1f).setDuration(150)

            val edtJawaban =
                ObjectAnimator.ofFloat(binding.edtJawaban, View.ALPHA, 1f).setDuration(150)

            btnSubmit.isClickable = true
            val btnSubmit =
                ObjectAnimator.ofFloat(binding.btnSubmit, View.ALPHA, 1f).setDuration(150)


            AnimatorSet().apply {
                playSequentially(
                    soalPertanyaan,
                    edtJawaban,
                    btnSubmit
                )
                start()
            }
        }
    }

    private fun hideDataLayoutEssay() {
        binding.apply {
            soalPertanyaan.alpha = 0f
            edtJawaban.alpha = 0f
            btnSubmit.alpha = 0f
            btnSubmit.isClickable = false
        }
    }

    private fun showDataLayout() {
        binding.apply {
            soalPertanyaan.text = soal[indexSoal]
            val soalPertanyaan =
                ObjectAnimator.ofFloat(binding.soalPertanyaan, View.ALPHA, 1f).setDuration(150)

            btnOpsiA.text = opsi1[indexSoal]
            btnOpsiA.isClickable = true
            val opt_red = ObjectAnimator.ofFloat(binding.btnOpsiA, View.ALPHA, 1f).setDuration(150)

            btnOpsiB.text = opsi2[indexSoal]
            btnOpsiB.isClickable = true
            val opt_yellow =
                ObjectAnimator.ofFloat(binding.btnOpsiB, View.ALPHA, 1f).setDuration(150)

            btnOpsiC.text = opsi3[indexSoal]
            btnOpsiC.isClickable = true
            val opt_green =
                ObjectAnimator.ofFloat(binding.btnOpsiC, View.ALPHA, 1f).setDuration(150)

            btnOpsiD.text = opsi4[indexSoal]
            btnOpsiD.isClickable = true
            val opt_blue = ObjectAnimator.ofFloat(binding.btnOpsiD, View.ALPHA, 1f).setDuration(150)

            AnimatorSet().apply {
                playSequentially(
                    soalPertanyaan,
                    opt_red,
                    opt_yellow,
                    opt_green,
                    opt_blue,
                )
                start()
            }
        }
    }

    private fun hideDataLayout() {
        binding.apply {
            soalPertanyaan.alpha = 0f

            btnOpsiA.alpha = 0f
            btnOpsiA.isClickable = false

            btnOpsiB.alpha = 0f
            btnOpsiB.isClickable = false

            btnOpsiC.alpha = 0f
            btnOpsiC.isClickable = false

            btnOpsiD.alpha = 0f
            btnOpsiD.isClickable = false
        }
    }

    private fun showLoading() {
        progressDialog = ProgressDialog.show(this, "", "Loading...", true)
    }

    private fun hideLoading() {
        progressDialog?.dismiss()
    }
}