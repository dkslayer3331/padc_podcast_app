package com.mhst.padc_podcast_app.data.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Moe Htet on 05,September,2020
 */
object PodcastModelImpl : PodcastModel, BaseModel() {

    override fun getAllGenres(onError: (String) -> Unit): LiveData<List<GenreVO>>{
       return mDb.genreDao().getAllGenres()
    }

    override fun getGenresAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mApi.getGenres(0)
            .flatMap {
                mDb.genreDao().deleteInsert(it.genres)
                return@flatMap Observable.just(it)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            },{
                Log.d("firstTimeGenre",it.localizedMessage)
                onError(it.localizedMessage)
            })
    }

    override fun getRandomPodcast(onError: (String) -> Unit) {
        mApi.getRandomPodcast().flatMap {
            return@flatMap Observable.just(it)
        }
    }

    override fun getPlayListAndSaveToDb(onSuccess: () -> Unit, onError: (String) -> Unit) {

    }

    override fun getAllPlayLists(onError: (String) -> Unit): LiveData<List<PlaylistVo>> {
        val gg  = MutableLiveData(listOf<PlaylistVo>())
        return  gg
    }

    override fun getAndSaveAll(onSuccess: () -> Unit) {

    }

}