package com.mhst.padc_podcast_app.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.mhst.padc_podcast_app.data.model.PodcastModel
import com.mhst.padc_podcast_app.data.model.PodcastModelImpl

/**
 * Created by Moe Htet on 05,September,2020
 */
abstract class BaseWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams){

    val model : PodcastModel = PodcastModelImpl

}