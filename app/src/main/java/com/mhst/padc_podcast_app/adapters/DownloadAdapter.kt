package com.mhst.padc_podcast_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.data.DummyVo
import com.mhst.padc_podcast_app.view.DownloadViewholder
import com.mhst.shared.base.BaseRecyclerAdapter

/**
 * Created by Moe Htet on 30,August,2020
 */
class DownloadAdapter : BaseRecyclerAdapter<DownloadViewholder,DummyVo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DownloadViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_download,parent,false)
        return DownloadViewholder(view)
    }
}