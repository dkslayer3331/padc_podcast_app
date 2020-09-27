package com.mhst.padc_podcast_app.view.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mhst.padc_podcast_app.data.dummy.DummyVo
import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.delegate.PodcastDelegate
import com.mhst.shared.base.BaseViewHolder
import kotlinx.android.synthetic.main.viewholder_upnext.view.*

/**
 * Created by Moe Htet on 30,August,2020
 */
class UpNextViewHolder(itemView: View,delegate: PodcastDelegate) : BaseViewHolder<PlaylistVo>(itemView) {

    init {
        itemView.setOnClickListener {
            delegate.onTap(mData ?: PlaylistVo())
        }
    }

    override fun bindData(data: PlaylistVo) {
        mData = data
        Glide.with(itemView.context).load(data.data.image).into(itemView.ivPlayList)
        itemView.tvHoursLeft.text = ""
        itemView.tvPlaylistLabel.text = data.data.podcast.title
        itemView.tvPlaylistTitle.text = data.data.title
    }
}