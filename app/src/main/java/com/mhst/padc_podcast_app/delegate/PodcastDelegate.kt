package com.mhst.padc_podcast_app.delegate

import com.mhst.padc_podcast_app.data.vo.PlaylistVo

/**
 * Created by Moe Htet on 27,September,2020
 */
interface PodcastDelegate {
    fun onTap(playlistVo : PlaylistVo)
}