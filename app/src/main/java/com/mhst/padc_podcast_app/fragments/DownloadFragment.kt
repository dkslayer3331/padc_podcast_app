package com.mhst.padc_podcast_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.activities.DetailActivity
import com.mhst.padc_podcast_app.adapters.DownloadAdapter
import com.mhst.padc_podcast_app.adapters.UpNextAdapter
import com.mhst.padc_podcast_app.data.dummy.DummyDataUtils
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.mvp.presenters.DownloadPresenter
import com.mhst.padc_podcast_app.mvp.presenters.impls.DownloadPresenterImpl
import com.mhst.padc_podcast_app.mvp.view.DownloadView
import kotlinx.android.synthetic.main.fragment_download.*

class DownloadFragment : Fragment(), DownloadView {

    private lateinit var downloadAdapter: UpNextAdapter

    lateinit var downloadPresenter: DownloadPresenter

    private fun setupRecycler(){
        downloadAdapter = UpNextAdapter(this,true)
        rvDownload.adapter = downloadAdapter
    }

    private fun setupPresenter(){
        downloadPresenter = ViewModelProvider(this).get(DownloadPresenterImpl::class.java)
        downloadPresenter.initPresenter(this)
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
        setupPresenter()
        setupRecycler()
        downloadPresenter.onUiReady(this)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            DownloadFragment()
    }

    override fun showDownloads(list: List<PodcastWrapperVo>) {
        downloadAdapter.setNewData(list.toMutableList())
    }

    override fun onTap(id: String) {
        startActivity(DetailActivity.onNewIntent(requireActivity(),id))
    }

    override fun onTapDownload(podcastWrapperVo: PodcastWrapperVo, itemview: View) {

    }
}