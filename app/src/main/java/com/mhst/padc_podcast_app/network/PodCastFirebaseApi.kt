package com.mhst.padc_podcast_app.network

import androidx.lifecycle.LiveData
import com.mhst.padc_podcast_app.data.vo.DownloadVO
import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.network.responses.RandomPodcastResponse

/**
 * Created by Moe Htet on 26,September,2020
 */
interface PodCastFirebaseApi {
    fun getPlayList(onSuccess: (LiveData<List<PodcastWrapperVo>>) -> Unit, onFail : (String) -> Unit)
    fun getGenres(onSuccess: (LiveData<List<GenreVO>>) -> Unit, onFail : (String) -> Unit)
    fun getDownloads(onSuccess: (LiveData<List<DownloadVO>>) -> Unit,onFail: (String) -> Unit)
    fun saveDownload(podcastWrapperVo: PodcastWrapperVo,onFail: (String) -> Unit)
    fun getRandomPodcast() : PodcastWrapperVo
    fun getDetail(id : String) : PodcastWrapperVo
}