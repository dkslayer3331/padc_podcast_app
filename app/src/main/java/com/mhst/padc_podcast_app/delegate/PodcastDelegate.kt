package com.mhst.padc_podcast_app.delegate

import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo

/**
 * Created by Moe Htet on 27,September,2020
 */
interface PodcastDelegate {
    fun onTap(podcastWrapperVo : PodcastWrapperVo)
}