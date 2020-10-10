package com.mhst.padc_podcast_app.data.model

import androidx.lifecycle.LiveData
import com.mhst.padc_podcast_app.data.vo.DownloadVO
import com.mhst.padc_podcast_app.network.PodCastFirebaseApi
import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo

/**
 * Created by Moe Htet on 05,September,2020
 */
interface PodcastModel {

    fun getPlayList(onSuccess: (LiveData<List<PodcastWrapperVo>>) -> Unit, onFail : (String) -> Unit)
    fun getRandomPodcast() : PodcastWrapperVo
    fun getGenres(onSuccess: (LiveData<List<GenreVO>>) -> Unit, onFail : (String) -> Unit)
    fun getDownloads(onSuccess: (LiveData<List<DownloadVO>>) -> Unit , onFail: (String) -> Unit)
    fun saveDownloads(podcastWrapperVo: PodcastWrapperVo,onFail: (String) -> Unit)
    fun getDetail(id : String) : PodcastWrapperVo
    fun getLargeGenre() : GenreVO


}