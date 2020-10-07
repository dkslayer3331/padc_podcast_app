package com.mhst.padc_podcast_app.data.model

import androidx.lifecycle.LiveData
import com.mhst.padc_podcast_app.data.vo.DownloadVO
import com.mhst.padc_podcast_app.network.PodCastFirebaseApi
import com.mhst.padc_podcast_app.network.FirebaseApiImpl
import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.network.CloudFireStoreImpl

/**
 * Created by Moe Htet on 27,September,2020
 */
object PodcastModelImpl : PodcastModel{

    //realtime database
    //private var mApi: PodCastFirebaseApi = FirebaseApiImpl

    //cloudfirestore
    private var mApi: PodCastFirebaseApi = CloudFireStoreImpl

    override fun getPlayList(
        onSuccess: (LiveData<List<PodcastWrapperVo>>) -> Unit,
        onFail: (String) -> Unit
    ) {
        mApi.getPlayList(onSuccess, onFail)
    }

    override fun getGenres(onSuccess: (LiveData<List<GenreVO>>) -> Unit, onFail: (String) -> Unit) {
        mApi.getGenres(onSuccess, onFail)
    }

    override fun getDownloads(
        onSuccess: (LiveData<List<DownloadVO>>) -> Unit,
        onFail: (String) -> Unit
    ) {
        mApi.getDownloads(onSuccess,onFail)
    }

    override fun saveDownloads(podcastWrapperVo: PodcastWrapperVo, onFail: (String) -> Unit) {
        mApi.saveDownload(podcastWrapperVo,onFail)
    }
}