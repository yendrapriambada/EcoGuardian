package com.fikri.ecoguardian

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fikri.ecoguardian.databinding.ActivityGame2Binding

class Game2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityGame2Binding
    private val trashList = mutableListOf<Pair<View, Rect>>()
    private var collisionEventHandled = false
    private var isTouchingView1 = false
    private var isMovingView1 = false
    private var isAlreadyThrownAway1 = false

    private var isTouchingView2 = false
    private var isMovingView2 = false
    private var isAlreadyThrownAway2 = false

    private var isTouchingView3 = false
    private var isMovingView3 = false
    private var isAlreadyThrownAway3 = false

    private var isTouchingView4 = false
    private var isMovingView4 = false
    private var isAlreadyThrownAway4 = false

    private var isTouchingView5 = false
    private var isMovingView5 = false
    private var isAlreadyThrownAway5 = false

    private var isTouchingView6 = false
    private var isMovingView6 = false
    private var isAlreadyThrownAway6 = false

    private var isTouchingView7 = false
    private var isMovingView7 = false
    private var isAlreadyThrownAway7 = false

    private var isTouchingView8 = false
    private var isMovingView8 = false
    private var isAlreadyThrownAway8 = false

    private var isTouchingView9 = false
    private var isMovingView9 = false
    private var isAlreadyThrownAway9 = false

    private var isTouchingView10 = false
    private var isMovingView10 = false
    private var isAlreadyThrownAway10 = false

    private var isTouchingView11 = false
    private var isMovingView11 = false
    private var isAlreadyThrownAway11 = false

    private val sampahRect = Rect()
    private val rubbishBinGreenRect = Rect()
    private val rubbishBinYellowRect = Rect()

    private lateinit var trashViews: List<ImageView>

    private var x: Float = 0.0f
    private var y: Float = 0.0f
    private var dx: Float = 0.0f
    private var dy: Float = 0.0f
    private var tempX: Float = 0.0f
    private var tempY: Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGame2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTrashList()
    }

    private fun setupTrashList() {
        trashViews = listOf(
            binding.apel, binding.pizza, binding.paper, binding.straw, binding.botol,
            binding.kaleng, binding.karton, binding.kresek, binding.roti, binding.pisang,
            binding.sayur
        )
        trashList.clear()
        trashViews.forEach { trashView ->
            val trashRect = Rect()
            trashList.add(trashView to trashRect)
        }

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                x = event.x
                y = event.y
                if (isInsideView(binding.apel, x, y) && !isAlreadyThrownAway1) {
                    isTouchingView1 = true
                    isMovingView1 = true
                } else if (isInsideView(binding.pizza, x, y) && !isAlreadyThrownAway2) {
                    isTouchingView2 = true
                    isMovingView2 = true
                } else if (isInsideView(binding.paper, x, y) && !isAlreadyThrownAway3) {
                    isTouchingView3 = true
                    isMovingView3 = true
                } else if (isInsideView(binding.straw, x, y) && !isAlreadyThrownAway4) {
                    isTouchingView4 = true
                    isMovingView4 = true
                } else if (isInsideView(binding.botol, x, y) && !isAlreadyThrownAway5) {
                    isTouchingView5 = true
                    isMovingView5 = true
                } else if (isInsideView(binding.kaleng, x, y) && !isAlreadyThrownAway6) {
                    isTouchingView6 = true
                    isMovingView6 = true
                } else if (isInsideView(binding.karton, x, y) && !isAlreadyThrownAway7) {
                    isTouchingView7 = true
                    isMovingView7 = true
                } else if (isInsideView(binding.kresek, x, y) && !isAlreadyThrownAway8) {
                    isTouchingView8 = true
                    isMovingView8 = true
                } else if (isInsideView(binding.roti, x, y) && !isAlreadyThrownAway9) {
                    isTouchingView9 = true
                    isMovingView9 = true
                } else if (isInsideView(binding.pisang, x, y) && !isAlreadyThrownAway10) {
                    isTouchingView10 = true
                    isMovingView10 = true
                } else if (isInsideView(binding.sayur, x, y) && !isAlreadyThrownAway11) {
                    isTouchingView11 = true
                    isMovingView11 = true
                }
            }
            MotionEvent.ACTION_MOVE -> {
                if (isMovingView1) {
                    dx = event.x - x
                    dy = event.y - y
                    binding.apel.x += dx
                    binding.apel.y += dy
                    x = event.x
                    y = event.y
                } else if (isMovingView2) {
                    dx = event.x - x
                    dy = event.y - y
                    binding.pizza.x += dx
                    binding.pizza.y += dy
                    x = event.x
                    y = event.y
                } else if (isMovingView3) {
                    dx = event.x - x
                    dy = event.y - y
                    binding.paper.x += dx
                    binding.paper.y += dy
                    x = event.x
                    y = event.y
                } else if (isMovingView4) {
                    dx = event.x - x
                    dy = event.y - y
                    binding.straw.x += dx
                    binding.straw.y += dy
                    x = event.x
                    y = event.y
                } else if (isMovingView5) {
                    dx = event.x - x
                    dy = event.y - y
                    binding.botol.x += dx
                    binding.botol.y += dy
                    x = event.x
                    y = event.y
                } else if (isMovingView6) {
                    dx = event.x - x
                    dy = event.y - y
                    binding.kaleng.x += dx
                    binding.kaleng.y += dy
                    x = event.x
                    y = event.y
                } else if (isMovingView7) {
                    dx = event.x - x
                    dy = event.y - y
                    binding.karton.x += dx
                    binding.karton.y += dy
                    x = event.x
                    y = event.y
                } else if (isMovingView8) {
                    dx = event.x - x
                    dy = event.y - y
                    binding.kresek.x += dx
                    binding.kresek.y += dy
                    x = event.x
                    y = event.y
                } else if (isMovingView9) {
                    dx = event.x - x
                    dy = event.y - y
                    binding.roti.x += dx
                    binding.roti.y += dy
                    x = event.x
                    y = event.y
                } else if (isMovingView10) {
                    dx = event.x - x
                    dy = event.y - y
                    binding.pisang.x += dx
                    binding.pisang.y += dy
                    x = event.x
                    y = event.y
                } else if (isMovingView11) {
                    dx = event.x - x
                    dy = event.y - y
                    binding.sayur.x += dx
                    binding.sayur.y += dy
                    x = event.x
                    y = event.y
                } else if (!isTouchingView1 && !isTouchingView2 && !isTouchingView3 && !isTouchingView4 &&
                    !isTouchingView5 && !isTouchingView6 && !isTouchingView7 && !isTouchingView8 && !isTouchingView9 && !isTouchingView10 && !isTouchingView11
                ) {
                    dx = event.x - x
                    dy = event.y - y
                    handleTrashMovement(event.x, event.y)
                    x = event.x
                    y = event.y
                }
            }

            MotionEvent.ACTION_UP -> {
                rubbishBinGreenRect.left = binding.trashgreen.x.toInt()
                rubbishBinGreenRect.top = binding.trashgreen.y.toInt()
                rubbishBinGreenRect.right = binding.trashgreen.x.toInt() + binding.trashgreen.width
                rubbishBinGreenRect.bottom = binding.trashgreen.y.toInt() + binding.trashgreen.height

                rubbishBinYellowRect.left = binding.trashyellow.x.toInt()
                rubbishBinYellowRect.top = binding.trashyellow.y.toInt()
                rubbishBinYellowRect.right = binding.trashyellow.x.toInt() + binding.trashyellow.width
                rubbishBinYellowRect.bottom = binding.trashyellow.y.toInt() + binding.trashyellow.height

                if (isTouchingView1) {
                    isTouchingView1 = false
                    isMovingView1 = false
                    Log.d("View Touched:", "Apel")

                    sampahRect.left = binding.apel.x.toInt()
                    sampahRect.top = binding.apel.y.toInt()
                    sampahRect.right = binding.apel.x.toInt() + binding.apel.width
                    sampahRect.bottom = binding.apel.y.toInt() + binding.apel.height

                    val stateGreen = hasCollision(sampahRect, rubbishBinGreenRect)
                    val stateYellow = hasCollision(sampahRect, rubbishBinYellowRect)

                    Log.d("Has Collision:", stateGreen.toString())

                    if (stateGreen && !stateYellow){
                        binding.apel.visibility = View.GONE
                        isAlreadyThrownAway1 = true
                    }
                } else if (isTouchingView2) {
                    isTouchingView2 = false
                    isMovingView2 = false
                    Log.d("View Touched:", "Pizza")

                    sampahRect.left = binding.pizza.x.toInt()
                    sampahRect.top = binding.pizza.y.toInt()
                    sampahRect.right = binding.pizza.x.toInt() + binding.pizza.width
                    sampahRect.bottom = binding.pizza.y.toInt() + binding.pizza.height

                    val stateGreen = hasCollision(sampahRect, rubbishBinGreenRect)
                    val stateYellow = hasCollision(sampahRect, rubbishBinYellowRect)

                    Log.d("Has Collision:", stateGreen.toString())

                    if (stateGreen && !stateYellow){
                        binding.pizza.visibility = View.GONE
                        isAlreadyThrownAway2 = true
                    }
                } else if (isTouchingView3) {
                    isTouchingView3 = false
                    isMovingView3 = false
                    Log.d("View Touched:", "Paper")

                    sampahRect.left = binding.paper.x.toInt()
                    sampahRect.top = binding.paper.y.toInt()
                    sampahRect.right = binding.paper.x.toInt() + binding.paper.width
                    sampahRect.bottom = binding.paper.y.toInt() + binding.paper.height

                    val stateGreen = hasCollision(sampahRect, rubbishBinGreenRect)
                    val stateYellow = hasCollision(sampahRect, rubbishBinYellowRect)

                    Log.d("Has Collision:", stateGreen.toString())

                    if (stateGreen && !stateYellow){
                        binding.paper.visibility = View.GONE
                        isAlreadyThrownAway3 = true
                    }
                } else if (isTouchingView4) {
                    isTouchingView4 = false
                    isMovingView4 = false
                    Log.d("View Touched:", "Straw")

                    sampahRect.left = binding.straw.x.toInt()
                    sampahRect.top = binding.straw.y.toInt()
                    sampahRect.right = binding.straw.x.toInt() + binding.straw.width
                    sampahRect.bottom = binding.straw.y.toInt() + binding.straw.height

                    val stateGreen = hasCollision(sampahRect, rubbishBinGreenRect)
                    val stateYellow = hasCollision(sampahRect, rubbishBinYellowRect)

                    Log.d("Has Collision:", stateYellow.toString())

                    if (!stateGreen && stateYellow){
                        binding.straw.visibility = View.GONE
                        isAlreadyThrownAway4 = true
                    }
                } else if (isTouchingView5) {
                    isTouchingView5 = false
                    isMovingView5 = false
                    Log.d("View Touched:", "Botol")

                    sampahRect.left = binding.botol.x.toInt()
                    sampahRect.top = binding.botol.y.toInt()
                    sampahRect.right = binding.botol.x.toInt() + binding.botol.width
                    sampahRect.bottom = binding.botol.y.toInt() + binding.botol.height

                    val stateGreen = hasCollision(sampahRect, rubbishBinGreenRect)
                    val stateYellow = hasCollision(sampahRect, rubbishBinYellowRect)

                    Log.d("Has Collision:", stateYellow.toString())

                    if (!stateGreen && stateYellow){
                        binding.botol.visibility = View.GONE
                        isAlreadyThrownAway5 = true
                    }
                } else if (isTouchingView6) {
                    isTouchingView6 = false
                    isMovingView6 = false
                    Log.d("View Touched:", "Kaleng")

                    sampahRect.left = binding.kaleng.x.toInt()
                    sampahRect.top = binding.kaleng.y.toInt()
                    sampahRect.right = binding.kaleng.x.toInt() + binding.kaleng.width
                    sampahRect.bottom = binding.kaleng.y.toInt() + binding.kaleng.height

                    val stateGreen = hasCollision(sampahRect, rubbishBinGreenRect)
                    val stateYellow = hasCollision(sampahRect, rubbishBinYellowRect)

                    Log.d("Has Collision:", stateYellow.toString())

                    if (!stateGreen && stateYellow){
                        binding.kaleng.visibility = View.GONE
                        isAlreadyThrownAway6 = true
                    }
                } else if (isTouchingView7) {
                    isTouchingView7 = false
                    isMovingView7 = false
                    Log.d("View Touched:", "Karton")

                    sampahRect.left = binding.karton.x.toInt()
                    sampahRect.top = binding.karton.y.toInt()
                    sampahRect.right = binding.karton.x.toInt() + binding.karton.width
                    sampahRect.bottom = binding.karton.y.toInt() + binding.karton.height

                    val stateGreen = hasCollision(sampahRect, rubbishBinGreenRect)
                    val stateYellow = hasCollision(sampahRect, rubbishBinYellowRect)

                    Log.d("Has Collision:", stateYellow.toString())

                    if (!stateGreen && stateYellow){
                        binding.karton.visibility = View.GONE
                        isAlreadyThrownAway7 = true
                    }
                } else if (isTouchingView8) {
                    isTouchingView8 = false
                    isMovingView8 = false
                    Log.d("View Touched:", "Kresek")

                    sampahRect.left = binding.kresek.x.toInt()
                    sampahRect.top = binding.kresek.y.toInt()
                    sampahRect.right = binding.kresek.x.toInt() + binding.kresek.width
                    sampahRect.bottom = binding.kresek.y.toInt() + binding.kresek.height

                    val stateGreen = hasCollision(sampahRect, rubbishBinGreenRect)
                    val stateYellow = hasCollision(sampahRect, rubbishBinYellowRect)

                    Log.d("Has Collision:", stateYellow.toString())

                    if (!stateGreen && stateYellow){
                        binding.kresek.visibility = View.GONE
                        isAlreadyThrownAway8 = true
                    }
                } else if (isTouchingView9) {
                    isTouchingView9 = false
                    isMovingView9 = false
                    Log.d("View Touched:", "Roti")

                    sampahRect.left = binding.roti.x.toInt()
                    sampahRect.top = binding.roti.y.toInt()
                    sampahRect.right = binding.roti.x.toInt() + binding.roti.width
                    sampahRect.bottom = binding.roti.y.toInt() + binding.roti.height

                    val stateGreen = hasCollision(sampahRect, rubbishBinGreenRect)
                    val stateYellow = hasCollision(sampahRect, rubbishBinYellowRect)

                    Log.d("Has Collision:", stateGreen.toString())

                    if (stateGreen && !stateYellow){
                        binding.roti.visibility = View.GONE
                        isAlreadyThrownAway9 = true
                    }
                } else if (isTouchingView10) {
                    isTouchingView10 = false
                    isMovingView10 = false
                    Log.d("View Touched:", "Pisang")

                    sampahRect.left = binding.pisang.x.toInt()
                    sampahRect.top = binding.pisang.y.toInt()
                    sampahRect.right = binding.pisang.x.toInt() + binding.pisang.width
                    sampahRect.bottom = binding.pisang.y.toInt() + binding.pisang.height

                    val stateGreen = hasCollision(sampahRect, rubbishBinGreenRect)
                    val stateYellow = hasCollision(sampahRect, rubbishBinYellowRect)

                    Log.d("Has Collision:", stateGreen.toString())

                    if (stateGreen && !stateYellow){
                        binding.pisang.visibility = View.GONE
                        isAlreadyThrownAway10 = true
                    }
                } else if (isTouchingView11) {
                    isTouchingView11 = false
                    isMovingView11 = false
                    Log.d("View Touched:", "Sayur")

                    sampahRect.left = binding.sayur.x.toInt()
                    sampahRect.top = binding.sayur.y.toInt()
                    sampahRect.right = binding.sayur.x.toInt() + binding.sayur.width
                    sampahRect.bottom = binding.sayur.y.toInt() + binding.sayur.height

                    val stateGreen = hasCollision(sampahRect, rubbishBinGreenRect)
                    val stateYellow = hasCollision(sampahRect, rubbishBinYellowRect)

                    Log.d("Has Collision:", stateGreen.toString())

                    if (stateGreen && !stateYellow){
                        binding.sayur.visibility = View.GONE
                        isAlreadyThrownAway11 = true
                    }
                }

                if (isAlreadyThrownAway1 && isAlreadyThrownAway2 && isAlreadyThrownAway3 && isAlreadyThrownAway4 &&
                    isAlreadyThrownAway5 && isAlreadyThrownAway6 && isAlreadyThrownAway7 && isAlreadyThrownAway8 &&
                    isAlreadyThrownAway9 && isAlreadyThrownAway10 && isAlreadyThrownAway11) {
                    Toast.makeText(this, "selamat kamu berhasil membantu flora untuk membersihkan sampah sesuai jenisnya", Toast.LENGTH_SHORT).show()
                    Intent(this@Game2Activity, GameInstructionsActivity::class.java).also {
                        startActivity(it)
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }

    private fun handleTrashMovement(x: Float, y: Float) {
        val touchedTrash = trashList.firstOrNull { isInsideView(it.first, x, y) }?.first

        touchedTrash?.let { trashView ->
            trashView.x += dx
            trashView.y += dy
            val trashRect = trashList.find { it.first == trashView }?.second
            trashRect?.apply {
                left = trashView.x.toInt()
                top = trashView.y.toInt()
                right = trashView.x.toInt() + trashView.width
                bottom = trashView.y.toInt() + trashView.height
            }
        }
    }

    private fun isInsideView(view: View, x: Float, y: Float): Boolean {
        val rect = Rect()
        view.getGlobalVisibleRect(rect)
        return rect.contains(x.toInt(), y.toInt())
    }

    private fun hasCollision(one: Rect, two: Rect): Boolean {
        return one.left < two.right && one.right > two.left && one.top < two.bottom && one.bottom > two.top
    }
}
