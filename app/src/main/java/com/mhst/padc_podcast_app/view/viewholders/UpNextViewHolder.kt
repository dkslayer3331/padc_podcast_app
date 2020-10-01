package com.mhst.padc_podcast_app.view.viewholders

import android.text.Html
import android.view.View
import com.bumptech.glide.Glide
import com.mhst.padc_podcast_app.data.dummy.DummyVo
import com.mhst.padc_podcast_app.data.vo.PlaylistVo
import com.mhst.padc_podcast_app.data.vo.PodcastWrapperVo
import com.mhst.padc_podcast_app.delegate.PodcastDelegate
import com.mhst.shared.base.BaseViewHolder
import kotlinx.android.synthetic.main.viewholder_upnext.view.*

/**
 * Created by Moe Htet on 30,August,2020
 */
class UpNextViewHolder(itemView: View,delegate: PodcastDelegate,val isDownload : Boolean) : BaseViewHolder<PodcastWrapperVo>(itemView) {

    init {
        itemView.setOnClickListener {
            delegate.onTap(mData ?: PodcastWrapperVo())
        }
        itemView.ivDownload.setOnClickListener {
            mData?.let {
                delegate.onTapDownload(it,itemView)
            }
        }
    }

    override fun bindData(data: PodcastWrapperVo) {
        mData = data
        if(isDownload){
            itemView.ivDownload.visibility = View.GONE
            itemView.progressBar.visibility = View.GONE
        }
        Glide.with(itemView.context).load(data.image).into(itemView.ivPlayList)
        itemView.tvHoursLeft.text = ""
        itemView.tvPlaylistLabel.text = data.title
        itemView.tvPlaylistTitle.text = Html.fromHtml(data.description)
    }
}