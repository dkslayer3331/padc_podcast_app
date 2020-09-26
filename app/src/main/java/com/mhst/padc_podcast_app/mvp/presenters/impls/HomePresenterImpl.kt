package com.mhst.padc_podcast_app.mvp.presenters.impls

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import com.mhst.padc_podcast_app.data.model.PodcastModel
import com.mhst.padc_podcast_app.data.model.PodcastModelImpl
import com.mhst.padc_podcast_app.mvp.AbstractBasePresenter
import com.mhst.padc_podcast_app.mvp.presenters.HomePresenter
import com.mhst.padc_podcast_app.mvp.view.HomeView

/**
 * Created by Moe Htet on 06,September,2020
 */
class HomePresenterImpl : HomePresenter, AbstractBasePresenter<HomeView>() {

    private val model : PodcastModel = PodcastModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        model.getPlayList(onSuccess = {
            mView?.displayTracks(it)
        },onFail = {
            Log.d("playlistErr",it)
        })
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        //
    }

    override fun getRandomPodcast() {
        model.getRandomPodcast(onSuccess = {
            mView?.playRandomPodcast(it.audio)
        },onFail = {
            Log.d("randomPodcastErr",it)
        })
    }

}