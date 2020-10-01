package com.mhst.padc_podcast_app.mvp.view

import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.delegate.PodcastDelegate
import com.mhst.padc_podcast_app.mvp.BaseView

/**
 * Created by Moe Htet on 01,October,2020
 */
interface DownloadView : BaseView,PodcastDelegate {
    fun showDownloads(list : List<PodcastWrapperVo>)
}