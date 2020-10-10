package com.mhst.padc_podcast_app.network

import androidx.lifecycle.LiveData
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mhst.padc_podcast_app.NO_INTERNET_CONNECTION
import com.mhst.padc_podcast_app.data.model.BaseModel
import com.mhst.padc_podcast_app.data.vo.DownloadVO
import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.data.vo.PodcastVo
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.utils.toGenre
import com.mhst.padc_podcast_app.utils.toPodcast

/**
 * Created by Moe Htet on 07,October,2020
 */
object CloudFireStoreImpl : PodCastFirebaseApi,BaseModel() {

    private val fireStore = Firebase.firestore

    override fun getPlayList(
        onSuccess: (LiveData<List<PodcastWrapperVo>>) -> Unit,
        onFail: (String) -> Unit
    ) {
        fireStore.collection("latest_episodes").addSnapshotListener { value, error ->
            error?.let {
                onFail(it?.message ?: NO_INTERNET_CONNECTION)
            } ?: run{

                val temp = mutableListOf<PodcastWrapperVo>()
                val datas = value?.documents ?: emptyList()

                for(data in datas){
                    val data = data.data
                    temp.add(data.toPodcast())
                }

                mDb.episodeDao().delteAllEpisodes()

                mDb.episodeDao().addAll(temp)

                onSuccess(mDb.episodeDao().getAllEpisodes())

            }
        }
    }

    override fun getGenres(onSuccess: (LiveData<List<GenreVO>>) -> Unit, onFail: (String) -> Unit) {
        fireStore.collection("genres").addSnapshotListener { value, error ->
            error?.let {
                onFail(it.message ?: NO_INTERNET_CONNECTION)
            } ?: run{
                val temp = mutableListOf<GenreVO>()
                 val datas = value?.documents ?: emptyList()

                for(data in datas){
                    val data = data.data
                    temp.add(data.toGenre())
                }

                mDb.genreDao().deleteAllGeneres()

                mDb.genreDao().addGenres(temp)

                onSuccess(mDb.genreDao().getAllGenres())

            }
        }
    }

    override fun getDownloads(
        onSuccess: (LiveData<List<DownloadVO>>) -> Unit,
        onFail: (String) -> Unit
    ) {
        try{
            onSuccess(mDb.downloadDao().getAllDownloads())
        }catch (e : Exception){
            onFail(e.localizedMessage)
        }
    }

    override fun saveDownload(podcastWrapperVo: PodcastWrapperVo, onFail: (String) -> Unit) {
        try {
            mDb.downloadDao().addDownload(DownloadVO(podcastWrapperVo.id,podcastWrapperVo))
        }catch ( e : Exception){
            onFail(e.localizedMessage)
        }
    }

    override fun getRandomPodcast(): PodcastWrapperVo {
        return mDb.episodeDao().getRandom()
    }

    override fun getDetail(id: String): PodcastWrapperVo {
        return mDb.episodeDao().getDetail(id)
    }

    override fun getLargeGenre(): GenreVO {
        return mDb.genreDao().getRandom()
    }
}