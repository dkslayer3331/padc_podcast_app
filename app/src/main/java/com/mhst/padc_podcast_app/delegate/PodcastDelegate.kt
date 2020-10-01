package com.mhst.padc_podcast_app.delegate

import android.view.View
import androidx.fragment.app.FragmentActivity
import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo

/**
 * Created by Moe Htet on 27,September,2020
 */
interface PodcastDelegate {
    fun onTap(podcastWrapperVo : PodcastWrapperVo)
    fun onTapDownload(podcastWrapperVo: PodcastWrapperVo,itemview: View)
}