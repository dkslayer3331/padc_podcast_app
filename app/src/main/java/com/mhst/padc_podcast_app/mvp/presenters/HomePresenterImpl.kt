package com.mhst.padc_podcast_app.mvp.presenters

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mhst.padc_podcast_app.data.model.PodcastModel
import com.mhst.padc_podcast_app.data.model.PodcastModelImpl
import com.mhst.padc_podcast_app.mvp.AbstractBasePresenter
import com.mhst.padc_podcast_app.mvp.view.GenreView
import com.mhst.padc_podcast_app.mvp.view.HomeView

/**
 * Created by Moe Htet on 06,September,2020
 */
object HomePresenterImpl : HomePresenter, AbstractBasePresenter<HomeView>() {

    val model : PodcastModel = PodcastModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        getPlayLists(lifecycleOwner)
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        getPlayLists(lifecycleOwner)
    }

    private fun getPlayLists(lifecycleOwner: LifecycleOwner){
        model.getAllPlayLists{
            mView?.disableSwipeRefresh()
            Log.d("playlistErrInPresenter",it)
        }.observe(lifecycleOwner, Observer {
            mView?.disableSwipeRefresh()
            it?.let {
                mView?.displayTracks(it)
            }
        })
    }

}