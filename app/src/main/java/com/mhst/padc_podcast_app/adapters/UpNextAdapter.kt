package com.mhst.padc_podcast_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.data.DummyVo
import com.mhst.padc_podcast_app.view.GenreViewHolder
import com.mhst.shared.base.BaseRecyclerAdapter

/**
 * Created by Moe Htet on 30,August,2020
 */
//for up next
class UpNextAdapter : BaseRecyclerAdapter<GenreViewHolder, DummyVo>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_upnext,parent,false)
        return GenreViewHolder(view)
    }
}