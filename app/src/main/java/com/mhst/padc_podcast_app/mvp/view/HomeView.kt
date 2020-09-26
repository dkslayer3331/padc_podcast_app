package com.mhst.padc_podcast_app.mvp.view

import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.mvp.BaseView

/**
 * Created by Moe Htet on 06,September,2020
 */
interface HomeView : BaseView {
    fun displayTracks(tracks : List<PlaylistVo>)
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
}