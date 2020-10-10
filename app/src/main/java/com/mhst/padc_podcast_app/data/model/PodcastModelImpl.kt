package com.mhst.padc_podcast_app.data.model

import android.util.Log
import androidx.lifecycle.LiveData
import com.mhst.padc_podcast_app.data.vo.DownloadVO
import com.mhst.padc_podcast_app.network.PodCastFirebaseApi
import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.network.CloudFireStoreImpl
import com.mhst.padc_podcast_app.network.RealTimeDbImpl

/**
 * Created by Moe Htet on 27,September,2020
 */
object PodcastModelImpl : PodcastModel,BaseModel(){

    //realtime database
    //private var mApi : PodCastFirebaseApi = RealTimeDbImpl

    //cloudfirestore
    private var mApi: PodCastFirebaseApi = CloudFireStoreImpl

    override fun getPlayList(
        onSuccess: (LiveData<List<PodcastWrapperVo>>) -> Unit,
        onFail: (String) -> Unit
    ) {
        mApi.getPlayList(onSuccess = {
            mDb.episodeDao().delteAllEpisodes()
            mDb.episodeDao().addAll(it)
            onSuccess(mDb.episodeDao().getAllEpisodes())
        }){
            onFail(it)
        }
    }

    override fun getRandomPodcast(): PodcastWrapperVo {
      return mDb.episodeDao().getRandom()
    }

    override fun getGenres(onSuccess: (LiveData<List<GenreVO>>) -> Unit, onFail: (String) -> Unit) {
       mApi.getGenres(onSuccess = {
           mDb.genreDao().deleteAllGeneres()
           mDb.genreDao().addGenres(it)
           onSuccess(mDb.genreDao().getAllGenres())
       }){
           onFail(it)
       }
    }

    override fun getDownloads(
        onSuccess: (LiveData<List<DownloadVO>>) -> Unit,
        onFail: (String) -> Unit
    ) {
        try {
            onSuccess(mDb.downloadDao().getAllDownloads())
        }catch (e : Exception){
            onFail(e.localizedMessage)
        }
    }

    override fun saveDownloads(podcastWrapperVo: PodcastWrapperVo, onFail: (String) -> Unit) {
       try {
           mDb.downloadDao().addDownload(DownloadVO(podcastWrapperVo.id,podcastWrapperVo))
       }catch (e : Exception){
           onFail(e.localizedMessage)
       }
    }

    override fun getDetail(id: String): PodcastWrapperVo {
       return mDb.episodeDao().getDetail(id)
    }

    override fun getLargeGenre(): GenreVO {
       return mDb.genreDao().getRandom()
    }

    override fun sayYahallo() {
        Log.d("thanks","for everything")
    }
}