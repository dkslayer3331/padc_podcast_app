package com.mhst.padc_podcast_app.view.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mhst.padc_podcast_app.data.dummy.DummyVo
import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.shared.base.BaseViewHolder
import kotlinx.android.synthetic.main.viewholder_upnext.view.*

/**
 * Created by Moe Htet on 30,August,2020
 */
class UpNextViewHolder(itemView: View) : BaseViewHolder<PlaylistVo>(itemView) {

    init {
        itemView.setOnClickListener {
        }
    }

    override fun bindData(data: PlaylistVo) {
        Glide.with(itemView.context).load(data.data.image).into(itemView.ivPlayList)
        itemView.tvHoursLeft.text = ""
        itemView.tvPlaylistLabel.text = data.data.podcast.title
        itemView.tvPlaylistTitle.text = data.data.title
    }
}