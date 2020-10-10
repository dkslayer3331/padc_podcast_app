package com.mhst.padc_podcast_app.mvp.presenters.impls

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mhst.padc_podcast_app.data.model.PodcastModel
import com.mhst.padc_podcast_app.data.model.PodcastModelImpl
import com.mhst.padc_podcast_app.mvp.AbstractBasePresenter
import com.mhst.padc_podcast_app.mvp.presenters.DownloadPresenter
import com.mhst.padc_podcast_app.mvp.view.DownloadView

/**
 * Created by Moe Htet on 01,October,2020
 */
class DownloadPresenterImpl : AbstractBasePresenter<DownloadView>() , DownloadPresenter{

    private val model : PodcastModel = PodcastModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        model.getDownloads(onSuccess = {
            it.observe(lifecycleOwner, Observer { it ->
                mView?.showDownloads(it.map { it.podcast })
            })
        },onFail = {
            Log.d("downloaderr",it)
        })
    }


}