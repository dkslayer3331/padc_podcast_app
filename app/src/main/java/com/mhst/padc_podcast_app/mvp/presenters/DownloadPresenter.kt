package com.mhst.padc_podcast_app.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mhst.padc_podcast_app.mvp.BasePresenter
import com.mhst.padc_podcast_app.mvp.view.DownloadView

/**
 * Created by Moe Htet on 01,October,2020
 */
interface DownloadPresenter : BasePresenter<DownloadView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}