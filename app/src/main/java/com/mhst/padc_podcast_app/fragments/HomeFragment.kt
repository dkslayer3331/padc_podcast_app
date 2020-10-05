package com.mhst.padc_podcast_app.fragments

import android.Manifest
import android.app.DownloadManager
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.activities.DetailActivity
import com.mhst.padc_podcast_app.adapters.UpNextAdapter
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.mvp.presenters.HomePresenter
import com.mhst.padc_podcast_app.mvp.presenters.impls.HomePresenterImpl
import com.mhst.padc_podcast_app.mvp.view.HomeView
import com.mhst.padc_podcast_app.view.viewpods.HomePlayerView
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(),HomeView {

    private lateinit var upNextAdapter: UpNextAdapter

    private lateinit var homePresenter: HomePresenter

    private lateinit var exoplayerViewpod: HomePlayerView

    var tempPodcast = PodcastWrapperVo()

    val reqCode = 3331

    override fun onStop() {
        super.onStop()
        exoplayerViewpod.releasePlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        exoplayerViewpod.releasePlayer()
    }

    private fun setupRecycler(){
        upNextAdapter = UpNextAdapter(this)
        rvUpNext.adapter = upNextAdapter
    }

    private fun setupPresenter(){
       activity?.let {
           homePresenter = ViewModelProvider(it)[HomePresenterImpl::class.java]
           homePresenter.initPresenter(this)
       }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exoplayerViewpod = vpMainPlayer as HomePlayerView
        setupRecycler()
        setupPresenter()
        homePresenter.onUiReady(this)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun displayTracks(tracks: List<PodcastWrapperVo>) {
        upNextAdapter.setNewData(tracks.toMutableList())
    }

    override fun enableSwipeRefresh() {

    }

    override fun disableSwipeRefresh() {

    }

    override fun playRandomPodcast(podcastWrapperVo: PodcastWrapperVo) {
        exoplayerViewpod.bindRandomPodcast(podcastWrapperVo)
    }

    override fun downloadPodcast(podcastWrapperVo: PodcastWrapperVo) {
        tempPodcast = podcastWrapperVo
        val permissionCheck =
            ContextCompat.checkSelfPermission(context!!, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if(permissionCheck != PackageManager.PERMISSION_GRANTED){
//            val manufacturer = "xiaomi"
//            if (manufacturer.equals(Build.MANUFACTURER, ignoreCase = true)) {
//                //this will open auto start screen where user can enable permission for your app
//                val intent = Intent()
//                intent.component = ComponentName(
//                    "com.miui.securitycenter",
//                    "com.miui.permcenter.autostart.AutoStartManagementActivity"
//                )
//                startActivity(intent)
//            }
            try{
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),reqCode)
            }catch (e : Exception){
                Log.d("reqErr",e.localizedMessage)
            }
        }
        else {
                val downloadManager = requireActivity().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                val uri = Uri.parse(podcastWrapperVo.audio)
                val request = DownloadManager.Request(uri)
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "${podcastWrapperVo.id}.mp3")
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                downloadManager.enqueue(request)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == reqCode){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && permissions[0] == Manifest.permission.WRITE_EXTERNAL_STORAGE) {
                val downloadManager = requireActivity().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                val uri = Uri.parse(tempPodcast.audio)
                val request = DownloadManager.Request(uri)
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "${tempPodcast.id}.mp3")
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                downloadManager.enqueue(request)
            }
            else {
                //requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),reqCode)
            }
        }
    }

    override fun onTap(podcastWrapperVo: PodcastWrapperVo) {
        startActivity(DetailActivity.onNewIntent(requireContext(),podcastWrapperVo))
    }

    override fun onTapDownload(podcastWrapperVo: PodcastWrapperVo, itemview: View) {
        homePresenter.onDownload(podcastWrapperVo,requireActivity())
    }
}