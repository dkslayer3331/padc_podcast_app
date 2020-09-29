package com.mhst.padc_podcast_app.data.model

import androidx.lifecycle.LiveData
import com.mhst.padc_podcast_app.network.PodCastFirebaseApi
import com.mhst.padc_podcast_app.data.FirebasePodcastImpl
import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo

/**
 * Created by Moe Htet on 27,September,2020
 */
object PodcastModelImpl : PodcastModel{

    //realtime database
    override var mApi: PodCastFirebaseApi = FirebasePodcastImpl

    override fun getPlayList(
        onSuccess: (LiveData<List<PodcastWrapperVo>>) -> Unit,
        onFail: (String) -> Unit
    ) {
        mApi.getPlayList(onSuccess, onFail)
    }

    override fun getGenres(onSuccess: (LiveData<List<GenreVO>>) -> Unit, onFail: (String) -> Unit) {
        mApi.getGenres(onSuccess, onFail)
    }
}