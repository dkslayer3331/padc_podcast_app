package com.mhst.padc_podcast_app.mvp.presenters

import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.mvp.BasePresenter
import com.mhst.padc_podcast_app.mvp.view.HomeView

/**
 * Created by Moe Htet on 06,September,2020
 */
interface HomePresenter : BasePresenter<HomeView> {
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun onDownload(podcastWrapperVo: PodcastWrapperVo,fragmentActivity: FragmentActivity,itemView : View)
}