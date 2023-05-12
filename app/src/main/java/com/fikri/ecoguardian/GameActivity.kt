package com.fikri.ecoguardian

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityGameBinding
import java.util.*


class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private var soal: ArrayList<String> = ArrayList()
    private var opsi1: ArrayList<String> = ArrayList()
    private var opsi2: ArrayList<String> = ArrayList()
    private var opsi3: ArrayList<String> = ArrayList()
    private var opsi4: ArrayList<String> = ArrayList()
    private var jawaban: ArrayList<String> = ArrayList()
    private var jawabanUser: ArrayList<String> = ArrayList()
    private var score = 0
    private var indexSoal = 0
    private var progressDialog: ProgressDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val soalArray = resources.getStringArray(R.array.questions)
        val optionsAArray = resources.getStringArray(R.array.optionsA)
        val optionsBArray = resources.getStringArray(R.array.optionsB)
        val optionsCArray = resources.getStringArray(R.array.optionsC)
        val optionsDArray = resources.getStringArray(R.array.optionsD)
        val jawabanArray = resources.getStringArray(R.array.jawaban)
        soal = ArrayList<String>(soalArray.toList())
        opsi1 = ArrayList<String>(optionsAArray.toList())
        opsi2 = ArrayList<String>(optionsBArray.toList())
        opsi3 = ArrayList<String>(optionsCArray.toList())
        opsi4 = ArrayList<String>(optionsDArray.toList())
        jawaban = ArrayList<String>(jawabanArray.toList())

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
        }
    }

    private fun quizAlgorithm() {
        hideDataLayout()
        showLoading()

        indexSoal++

        if (indexSoal >= soal.size) {
            // jika semua soal sudah di jawab
            for (i in 0 until jawabanUser.size) {
                if (jawabanUser[i] == jawaban[i].lowercase(Locale.getDefault())) {
                    score += 100
                }
            }
            score /= soal.size
            val intent = Intent(this@GameActivity, ResultActivity::class.java)
            intent.putExtra("hasilScore", score)
            startActivity(intent)
            finish()
            hideLoading()
        } else {
            showDataLayout()
            hideLoading()
        }
    }

    private fun showDataLayout() {
        binding.apply {
            soalPertanyaan.text = soal[indexSoal]
            val soalPertanyaan =
                ObjectAnimator.ofFloat(binding.soalPertanyaan, View.ALPHA, 1f).setDuration(150)

            btnOpsiA.text = opsi1[indexSoal]
            val opt_red = ObjectAnimator.ofFloat(binding.btnOpsiA, View.ALPHA, 1f).setDuration(150)

            btnOpsiB.text = opsi2[indexSoal]
            val opt_yellow =
                ObjectAnimator.ofFloat(binding.btnOpsiB, View.ALPHA, 1f).setDuration(150)

            btnOpsiC.text = opsi3[indexSoal]
            val opt_green =
                ObjectAnimator.ofFloat(binding.btnOpsiC, View.ALPHA, 1f).setDuration(150)

            btnOpsiD.text = opsi4[indexSoal]
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
            btnOpsiB.alpha = 0f
            btnOpsiC.alpha = 0f
            btnOpsiD.alpha = 0f
        }
    }

    private fun showLoading() {
        progressDialog = ProgressDialog.show(this, "", "Loading...", true)
    }

    private fun hideLoading() {
        progressDialog?.dismiss()
    }
}