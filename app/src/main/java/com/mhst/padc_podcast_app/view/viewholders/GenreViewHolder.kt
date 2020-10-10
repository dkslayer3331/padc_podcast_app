package com.mhst.padc_podcast_app.view.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mhst.padc_podcast_app.data.dummy.DummyVo
import com.mhst.padc_podcast_app.data.vo.GenreVO
import com.mhst.shared.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_image_recyclerview.view.*

/**
 * Created by Moe Htet on 03,September,2020
 */
class GenreViewHolder(itemView: View) : BaseViewHolder<GenreVO>(itemView) {
    override fun bindData(data: GenreVO) {
        itemView.tvGenreLabel.text = data.name
    }
}