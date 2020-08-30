package com.mhst.padc_podcast_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mhst.padc_podcast_app.R
import com.mhst.padc_podcast_app.data.DummyVo
import com.mhst.padc_podcast_app.view.SearchViewHolder
import com.mhst.shared.base.BaseRecyclerAdapter

/**
 * Created by Moe Htet on 30,August,2020
 */
class SearchAdapter : BaseRecyclerAdapter<SearchViewHolder, DummyVo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_search,parent,false)
        return SearchViewHolder(view)
    }
}