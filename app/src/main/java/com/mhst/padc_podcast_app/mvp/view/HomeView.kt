package com.mhst.padc_podcast_app.mvp.view

import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.delegate.PodcastDelegate
import com.mhst.padc_podcast_app.mvp.BaseView

/**
 * Created by Moe Htet on 06,September,2020
 */
interface HomeView : BaseView,PodcastDelegate {
    fun displayTracks(tracks : List<PodcastWrapperVo>)
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
    fun playRandomPodcast(url : String?)
}