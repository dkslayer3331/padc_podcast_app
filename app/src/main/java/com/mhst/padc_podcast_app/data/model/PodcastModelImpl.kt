package com.mhst.padc_podcast_app.data.model

import com.mhst.padc_podcast_app.data.PodCastFirebaseApi
import com.mhst.padc_podcast_app.data.PodcastImpl
import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.network.responses.RandomPodcastResponse

/**
 * Created by Moe Htet on 27,September,2020
 */
object PodcastModelImpl : PodcastModel {

    //realtime database
    override var mApi: PodCastFirebaseApi = PodcastImpl

    override fun getRandomPodcast(
        onSuccess: (PodcastWrapperVo) -> Unit,
        onFail: (String) -> Unit
    ) {
        mApi.getRandomPodcast(onSuccess,onFail)
    }

    override fun getPlayList(
        onSuccess: (List<PodcastWrapperVo>) -> Unit,
        onFail: (String) -> Unit
    ) {
        mApi.getPlayList(onSuccess, onFail)
    }

    override fun getGenres(onSuccess: (List<GenreVO>) -> Unit, onFail: (String) -> Unit) {
        mApi.getGenres(onSuccess, onFail)
    }
}