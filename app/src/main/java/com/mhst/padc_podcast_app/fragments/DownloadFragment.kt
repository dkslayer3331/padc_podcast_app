package com.mhst.padc_podcast_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mhst.padc_podcast_app.R

class DownloadFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_download, container, false)
        return root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            DownloadFragment()
    }
}