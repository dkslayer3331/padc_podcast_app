package com.mhst.padc_podcast_app.data.model

import androidx.lifecycle.LiveData
import com.mhst.padc_podcast_app.data.vo.GenreVO
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
                onError(it.localizedMessage)
            })
    }

}