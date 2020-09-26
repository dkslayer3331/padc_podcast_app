package com.mhst.padc_podcast_app.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mhst.padc_podcast_app.mvp.BasePresenter
import com.mhst.padc_podcast_app.mvp.view.HomeView

/**
 * Created by Moe Htet on 06,September,2020
 */
interface HomePresenter : BasePresenter<HomeView> {
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
    fun getRandomPodcast()
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}