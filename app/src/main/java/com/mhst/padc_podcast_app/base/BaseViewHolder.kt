package com.mhst.shared.base

/**
 * Created by Moe Htet on 29,August,2020
 */
import android.view.View
import androidx.recyclerview.widget.RecyclerView


abstract class BaseViewHolder<T>(itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    var mData : T? = null

    abstract fun bindData(data : T)
}