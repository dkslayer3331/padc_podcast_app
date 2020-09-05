package com.mhst.padc_podcast_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.data.dummy.DummyVo
import com.mhst.padc_podcast_app.view.GenreViewHolder
import com.mhst.shared.base.BaseRecyclerAdapter

/**
 * Created by Moe Htet on 03,September,2020
 */
class GenreAdapter : BaseRecyclerAdapter<GenreViewHolder, DummyVo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image_recyclerview,parent,false)
        return GenreViewHolder(view)
    }
}