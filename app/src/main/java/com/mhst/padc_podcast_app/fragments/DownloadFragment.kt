package com.mhst.padc_podcast_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.adapters.DownloadAdapter
import com.mhst.padc_podcast_app.adapters.UpNextAdapter
import com.mhst.padc_podcast_app.data.dummy.DummyDataUtils
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.mvp.view.DownloadView
import kotlinx.android.synthetic.main.fragment_download.*

class DownloadFragment : Fragment(), DownloadView {

    private lateinit var downloadAdapter: UpNextAdapter

    private fun setupRecycler(){
        downloadAdapter = UpNextAdapter(this,true)
        rvDownload.adapter = downloadAdapter
    }

    private fun setupPresenter(){

    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_download, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecycler()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            DownloadFragment()
    }

    override fun showDownloads(list: List<PodcastWrapperVo>) {
        downloadAdapter.setNewData(list.toMutableList())
    }

    override fun onTap(podcastWrapperVo: PodcastWrapperVo) {

    }

    override fun onTapDownload(podcastWrapperVo: PodcastWrapperVo) {

    }
}