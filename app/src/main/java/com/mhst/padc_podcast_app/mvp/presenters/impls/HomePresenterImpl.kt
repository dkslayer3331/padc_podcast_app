package com.mhst.padc_podcast_app.mvp.presenters.impls

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.mhst.padc_podcast_app.data.model.PodcastModel
import com.mhst.padc_podcast_app.data.model.PodcastModelImpl
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.mvp.AbstractBasePresenter
import com.mhst.padc_podcast_app.mvp.presenters.HomePresenter
import com.mhst.padc_podcast_app.mvp.view.HomeView
import kotlinx.android.synthetic.main.viewholder_upnext.view.*

/**
 * Created by Moe Htet on 06,September,2020
 */
class HomePresenterImpl : HomePresenter, AbstractBasePresenter<HomeView>() {

    private val model : PodcastModel = PodcastModelImpl

    private fun requestData(lifecycleOwner: LifecycleOwner){
        mView?.enableSwipeRefresh()
        model.getPlayList(onSuccess = {
            it.observe(lifecycleOwner, Observer {
                mView?.displayTracks(it)
                mView?.playRandomPodcast(model.getRandomPodcast())
                mView?.disableSwipeRefresh()
            })
        },onFail = {
            mView?.disableSwipeRefresh()
            Log.d("playlistErr",it)
        })
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        requestData(lifecycleOwner)
    }

    override fun onDownload(
        podcastWrapperVo: PodcastWrapperVo,
        fragmentActivity: FragmentActivity,
        itemView: View
    ) {
        model.saveDownloads(podcastWrapperVo){
            Log.d("downloadErr",it)
        }

        itemView.ivDownload.visibility = View.GONE

       // mView?.downloadPodcast(podcastWrapperVo)

        val downloadManager = fragmentActivity.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val uri = Uri.parse(podcastWrapperVo.audio)
        val request = DownloadManager.Request(uri)
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "${podcastWrapperVo.id}.mp3")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        downloadManager.enqueue(request)

    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        requestData(lifecycleOwner)
    }

}