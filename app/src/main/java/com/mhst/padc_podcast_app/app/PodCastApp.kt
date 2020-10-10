package com.mhst.padc_podcast_app.app

import android.app.Application
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.mhst.padc_podcast_app.data.model.PodcastModelImpl
import com.mhst.padc_podcast_app.network.CloudFireStoreImpl
import com.mhst.padc_podcast_app.workers.GenreWorker
import com.mhst.padc_podcast_app.workers.PlayListWorker

/**
 * Created by Moe Htet on 05,September,2020
 */
class PodCastApp : Application() {
    override fun onCreate() {
        super.onCreate()
        //FirebaseApiImpl.initDb(this)
        PodcastModelImpl.initDb(this)
//        oneTimeGenres()
//        oneTimePlayLists()
    }

    private fun oneTimeGenres(){
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(GenreWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }

    private fun oneTimePlayLists(){
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(PlayListWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }

}