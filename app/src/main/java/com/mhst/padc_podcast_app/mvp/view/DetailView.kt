package com.mhst.padc_podcast_app.mvp.view

import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.mvp.BaseView

/**
 * Created by Moe Htet on 27,September,2020
 */
interface DetailView  : BaseView{
    fun binData(podcastWrapperVo: PodcastWrapperVo)
    fun binAudio(url : String)
}