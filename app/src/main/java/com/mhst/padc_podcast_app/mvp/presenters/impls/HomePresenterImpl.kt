package com.mhst.padc_podcast_app.mvp.presenters.impls

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mhst.padc_podcast_app.data.model.PodcastModel
import com.mhst.padc_podcast_app.data.model.PodcastModelImpl
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
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
           it.observe(lifecycleOwner, Observer {
               mView?.displayTracks(it)
               mView?.playRandomPodcast(it.random().audio)
           })

        },onFail = {
            Log.d("playlistErr",it)
        })
    }

    override fun onDownload(
        podcastWrapperVo: PodcastWrapperVo,
        fragmentActivity: FragmentActivity
    ) {
        model.saveDownloads(podcastWrapperVo){
            Log.d("downloadErr",it)
        }

        val downloadManager = fragmentActivity.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val uri = Uri.parse(podcastWrapperVo.audio)
        val request = DownloadManager.Request(uri)
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "${podcastWrapperVo.id}.mp3")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        downloadManager.enqueue(request)

    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
    }

}