package com.mhst.padc_podcast_app.data.model

import android.app.DownloadManager
import android.util.Log
import androidx.lifecycle.LiveData
import com.mhst.padc_podcast_app.PLAYLIST_ID
import com.mhst.padc_podcast_app.data.vo.DataVo
import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.padc_podcast_app.data.vo.ItemVo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.Observables
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
        mApi.getPlayList(PLAYLIST_ID).flatMap {
            mDb.playListDao().deleteInsert(it.items)
            return@flatMap Observable.just(it)
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            },{
                Log.d("firstTimePlaylistErr",it.localizedMessage)
                onError(it.localizedMessage)
            })
    }

    override fun getAllPlayLists(onError: (String) -> Unit): LiveData<List<ItemVo>> {
        return mDb.playListDao().getAllTracks()
    }

}