package com.mhst.padc_podcast_app.workers

import android.content.Context
import androidx.work.WorkerParameters

/**
 * Created by Moe Htet on 06,September,2020
 */
class PlayListWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {
    override fun doWork(): Result {
        var result = Result.failure()
        return result
    }
}