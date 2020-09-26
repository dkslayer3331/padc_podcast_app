package com.mhst.padc_podcast_app.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mhst.padc_podcast_app.mvp.BasePresenter
import com.mhst.padc_podcast_app.mvp.view.GenreView

/**
 * Created by Moe Htet on 05,September,2020
 */
interface GenrePresenter : BasePresenter<GenreView> {
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}