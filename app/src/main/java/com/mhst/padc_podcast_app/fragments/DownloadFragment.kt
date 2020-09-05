package com.mhst.padc_podcast_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.adapters.DownloadAdapter
import com.mhst.padc_podcast_app.data.dummy.DummyDataUtils
import kotlinx.android.synthetic.main.fragment_download.*

class DownloadFragment : Fragment() {

    private lateinit var downloadAdapter: DownloadAdapter

    private fun setupRecycler(){
        downloadAdapter = DownloadAdapter()
        rvDownload.adapter = downloadAdapter
        downloadAdapter.setNewData(DummyDataUtils.getDummys())
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
}