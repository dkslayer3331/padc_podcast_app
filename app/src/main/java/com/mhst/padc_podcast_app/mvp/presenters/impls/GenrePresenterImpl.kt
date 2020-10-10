package com.mhst.padc_podcast_app.mvp.presenters.impls

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mhst.padc_podcast_app.data.model.PodcastModel
import com.mhst.padc_podcast_app.data.model.PodcastModelImpl
import com.mhst.padc_podcast_app.mvp.AbstractBasePresenter
import com.mhst.padc_podcast_app.mvp.presenters.GenrePresenter
import com.mhst.padc_podcast_app.mvp.view.GenreView

/**
 * Created by Moe Htet on 05,September,2020
 */
class GenrePresenterImpl : GenrePresenter, AbstractBasePresenter<GenreView>() {

    private val model : PodcastModel = PodcastModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        requestData(lifecycleOwner)
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        requestData(lifecycleOwner)
    }

    private fun requestData(lifecycleOwner: LifecycleOwner){
        mView?.enableSwipeRefresh()
        model.getGenres(onSuccess = {
            it.observe(lifecycleOwner, Observer {
                mView?.disableSwipeRefresh()
                mView?.displayGenres(it)
                mView?.displayLargeBanner(model.getLargeGenre())
            })
        },onFail = {
            mView?.disableSwipeRefresh()
            mView?.showError(it)
        })
    }


}