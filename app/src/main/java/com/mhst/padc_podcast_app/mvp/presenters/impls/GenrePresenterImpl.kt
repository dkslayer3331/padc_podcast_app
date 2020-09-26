package com.mhst.padc_podcast_app.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
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
        getGenres(lifecycleOwner)
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        getGenres(lifecycleOwner)
    }

    private fun getGenres(lifecycleOwner: LifecycleOwner){

    }

}