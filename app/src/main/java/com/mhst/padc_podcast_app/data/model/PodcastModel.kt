package com.mhst.padc_podcast_app.data.model

import androidx.lifecycle.LiveData
import com.mhst.padc_podcast_app.data.PodCastFirebaseApi
import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.network.responses.RandomPodcastResponse

/**
 * Created by Moe Htet on 05,September,2020
 */
interface PodcastModel {

    var mApi : PodCastFirebaseApi

    fun getRandomPodcast(onSuccess : (PodcastWrapperVo) -> Unit, onFail : (String) -> Unit)
    fun getPlayList(onSuccess: (List<PodcastWrapperVo>) -> Unit, onFail : (String) -> Unit)
    fun getGenres(onSuccess: (List<GenreVO>) -> Unit, onFail : (String) -> Unit)

}