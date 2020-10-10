package com.mhst.padc_podcast_app.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.mvp.BasePresenter
import com.mhst.padc_podcast_app.mvp.view.DetailView

/**
 * Created by Moe Htet on 27,September,2020
 */
interface DetailPresenter : BasePresenter<DetailView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner,id: String)
}