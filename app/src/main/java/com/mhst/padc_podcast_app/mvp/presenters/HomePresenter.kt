package com.mhst.padc_podcast_app.mvp.presenters

import androidx.lifecycle.LifecycleOwner

/**
 * Created by Moe Htet on 06,September,2020
 */
interface HomePresenter {
    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
}