package com.fikri.ecoguardian

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class MusicService : Service() {

    var mMediaPlayer: MediaPlayer? = null

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        mMediaPlayer = MediaPlayer.create(this, R.raw.smile1)
        mMediaPlayer!!.isLooping = true
        mMediaPlayer!!.setVolume(10f, 10f)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        if(intent.action == "PLAY") {
            if(!mMediaPlayer!!.isPlaying) {
                mMediaPlayer!!.start()
//                Toast.makeText(applicationContext, "Musik nyala", Toast.LENGTH_SHORT).show()
            }
        }
        if(intent.action == "STOP"){
            stopService(intent)
//            Toast.makeText(applicationContext, "Musik berhenti", Toast.LENGTH_SHORT).show()
        }
        return startId
    }

    override fun onDestroy() {
        mMediaPlayer!!.stop()
        mMediaPlayer!!.release()
    }
}