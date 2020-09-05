package com.mhst.padc_podcast_app.app

import android.app.Application
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.mhst.padc_podcast_app.data.model.PodcastModelImpl
import com.mhst.padc_podcast_app.workers.GenreWorker

/**
 * Created by Moe Htet on 05,September,2020
 */
class PodCastApp : Application() {
    override fun onCreate() {
        super.onCreate()
        PodcastModelImpl.initDb(this)
        oneTimeGenres()
    }

    private fun oneTimeGenres(){
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(GenreWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }

}