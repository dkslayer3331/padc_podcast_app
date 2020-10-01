package com.mhst.padc_podcast_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.data.dummy.DummyVo
import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.delegate.PodcastDelegate
import com.mhst.padc_podcast_app.view.viewholders.GenreViewHolder
import com.mhst.padc_podcast_app.view.viewholders.UpNextViewHolder
import com.mhst.shared.base.BaseRecyclerAdapter

/**
 * Created by Moe Htet on 30,August,2020
 */
//for up next
class UpNextAdapter(private val delegate: PodcastDelegate, private val isDownload : Boolean = false) : BaseRecyclerAdapter<UpNextViewHolder, PodcastWrapperVo>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpNextViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_upnext,parent,false)
        return UpNextViewHolder(view,delegate,isDownload)
    }
}