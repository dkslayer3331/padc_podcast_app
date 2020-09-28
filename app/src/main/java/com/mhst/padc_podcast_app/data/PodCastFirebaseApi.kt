package com.mhst.padc_podcast_app.data

import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.network.responses.RandomPodcastResponse

/**
 * Created by Moe Htet on 26,September,2020
 */
interface PodCastFirebaseApi {
    fun getRandomPodcast(onSuccess : (PodcastWrapperVo) -> Unit, onFail : (String) -> Unit)
    fun getPlayList(onSuccess: (List<PodcastWrapperVo>) -> Unit, onFail : (String) -> Unit)
    fun getGenres(onSuccess: (List<GenreVO>) -> Unit, onFail : (String) -> Unit)
}