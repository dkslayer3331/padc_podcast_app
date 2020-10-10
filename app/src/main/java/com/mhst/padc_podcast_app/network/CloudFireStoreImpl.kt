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
                    val podcastWrapperVo = PodcastWrapperVo()
                    podcastWrapperVo.id = data?.get("id") as String
                    podcastWrapperVo.maybeAudioInvalid = data?.get("maybe_audio_invalid") as Boolean
                    podcastWrapperVo.pubDateMs = data?.get("pub_date_ms") as Long
                    podcastWrapperVo.audio = data?.get("audio") as String
                    podcastWrapperVo.listennotesUrl = data?.get("listennotes_url") as String
                    podcastWrapperVo.title = data?.get("title") as String
                    podcastWrapperVo.description = data?.get("description") as String
                    podcastWrapperVo.link = data?.get("link") as String
                    podcastWrapperVo.audioLengthSec = (data?.get("audio_length_sec") as Long).toInt()
                    podcastWrapperVo.listennotesEditUrl = data?.get("listennotes_edit_url") as String
                    podcastWrapperVo.explicitContent = data?.get("explicit_content") as Boolean
                    podcastWrapperVo.thumbnail = data?.get("thumbnail") as String
                    podcastWrapperVo.image = data?.get("image") as String
                    val podcast = data?.get("podcast") as Map<String,Any>
                    podcastWrapperVo.podcast = PodcastVo(
                        image = podcast["image"] as String,
                        id = podcast["id"] as String,
                        thumbnail = podcast["thumbnail"] as String,
                        publisher = podcast["publisher"] as String,
                        listenNotesUrl = podcast["listennotes_url"] as String,
                        title = podcast["title"] as String
                    )
                    temp.add(podcastWrapperVo)
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
                    val genreVO = GenreVO()
                    genreVO.id = data?.get("id") as Long
                    genreVO.name = data?.get("name") as String
                    genreVO.parentId = data?.get("parent_id") as Long
                    temp.add(genreVO)
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